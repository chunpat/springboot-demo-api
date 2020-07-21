package com.chunpat.fengxiuapi.service;


import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class TestService {
    private int value = 111111;
    public void niubi(Integer age){
        System.out.println(age == this.value);
    }

//    public void niubi(Integer age,int page){
//        System.out.println("2");
//    }
}
