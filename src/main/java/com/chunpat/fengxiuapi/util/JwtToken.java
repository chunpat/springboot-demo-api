package com.chunpat.fengxiuapi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtToken {

    private static String jwtKey;
    private static Integer tokenExpiredIn;
    private static Integer defaultScope = 4;

    @Value("${chunpat.security.jwt-key}")
    public void setJwtKey(String jwtKey) {
        JwtToken.jwtKey = jwtKey;
    }
    @Value("${chunpat.security.token-expired-in}")
    public void setTokenExpiredIn(Integer tokenExpiredIn) {
        JwtToken.tokenExpiredIn = tokenExpiredIn;
    }

    public static String makeToken(Integer uid,Integer scope){
        return JwtToken.generateToken(uid,scope);
    }

    public static String makeToken(Integer uid){
        return JwtToken.generateToken(uid,JwtToken.defaultScope);
    }

    //生成token
    private static String generateToken(Integer uid,Integer scope){
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        Map<String,Date> date = JwtToken.calculateExpiredIssue();
        String token = JWT.create()
                .withClaim("scope",scope)
                .withClaim("uid",uid)
                .withExpiresAt(date.get("expiredTime"))
                .withIssuedAt(date.get("now"))
                .sign(algorithm);
        return token;
    }

    //过期时间处理
    private static Map<String,Date> calculateExpiredIssue(){
        Map<String,Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND,JwtToken.tokenExpiredIn);
        map.put("now",now);
        map.put("expiredTime",calendar.getTime());
        return map;
    }

    //验证
    public static DecodedJWT verify(String token){
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }

    //解密
//    private static DecodedJWT decode(String token){
//        DecodedJWT jwt = JWT.decode(token);
//        return jwt;
//    }
}
