package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.repository.UserRepository;
import com.chunpat.fengxiuapi.util.JwtToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Value("${wx.code2session}")
    private String code2session;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appkey}")
    private String appkey;

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserRepository userRepository;

    void getTokenByEmail(){

    }

    //微信
    void getTokenByWx(){

    }

    public String code2Session(String code){
        String url = MessageFormat.format(this.code2session,this.appid,this.appkey,code);
        RestTemplate rest = new RestTemplate();
        String sessionText = rest.getForObject(url,String.class);
        Map<String,Object> session = new HashMap<>();
        try {
            session = mapper.readValue(sessionText, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new NotFoundException(10003);
        }

        return this.registerUser(session);
    }

    public String registerUser(Map<String,Object> session){
        String openid = (String) session.get("openid");
        if(openid == null){
            throw new ParameterException(20004);
        }
        Optional<User> userOptional = userRepository.findByOpenid(openid);
        //不存在注册
        if(!userOptional.isPresent()){
            User user = User.builder().openid(openid).build();
            userRepository.save(user);
            return JwtToken.makeToken(user.getId().intValue());
        }
        return JwtToken.makeToken(userOptional.get().getId().intValue());
    }
}
