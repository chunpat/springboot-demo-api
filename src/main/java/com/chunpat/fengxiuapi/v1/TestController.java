package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @GetMapping("")
    public void test(){
        System.out.println(testService);
    }
}
