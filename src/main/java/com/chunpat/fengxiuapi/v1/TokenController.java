package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.dto.TokenGetDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@RequestMapping(value = "token")
@RestController
public class TokenController {

    @PostMapping("/getToken")

    public Map<String,String> getToken(@RequestParam @Validated  @NotBlank TokenGetDto account){
        switch ("222"){

        }
        return null;
    }
}
