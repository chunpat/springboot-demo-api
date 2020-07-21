package com.chunpat.fengxiuapi.v1;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.chunpat.fengxiuapi.dto.TokenDto;
import com.chunpat.fengxiuapi.dto.TokenGetDto;
import com.chunpat.fengxiuapi.exception.HttpException;
import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.service.AuthenticationService;
import com.chunpat.fengxiuapi.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "token")
@RestController
public class TokenController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("")
    public Map<String,String> getToken(
            @RequestBody @Validated TokenGetDto userData
    ){
        Map<String,String> map = new HashMap<>();
        String token = null;
        switch (userData.getLoginType()){
            case USER_WX:
                token = authenticationService.code2Session(userData.getAccount());
                break;
            case USER_EMAIL:
                throw new ParameterException(10004);
//                break;
            default:
                throw new ParameterException(10003);
        }
        map.put("token",token);
        return map;
    }

    @PostMapping("verify")
    public Map<String,Boolean> verifyToken(
            @RequestBody @NotBlank TokenDto token
    ){
        Map<String,Boolean> map = new HashMap<>();
        boolean valid = false;
        try {
            JwtToken.verify(token.getToken());
            valid = true;
        }catch (JWTVerificationException e){
        }
        map.put("is_valid",valid);
        return map;
    }
}
