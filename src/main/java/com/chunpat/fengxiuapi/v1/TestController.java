package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.dto.PersonDto;
import com.chunpat.fengxiuapi.model.Banner;
import com.chunpat.fengxiuapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @PostMapping("")
    public void test( @RequestBody @NotBlank PersonDto personDto){
        System.out.println("ape " + personDto.getName());
        this.testService.niubi(personDto.getAge());
//        this.testService.niubi(new Integer(1));
//        System.out.println(this.testService);
//        List<Integer> a1 = new ArrayList<Integer>();
//        a1.add(1);
//        Integer inter = new Integer(1);
//        inter.g
//        List<Object> a2 = a1;
        //plus拼接字符串方式
        String s = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s + String.valueOf(i);
        }
        long te = System.currentTimeMillis();
        System.out.println("Plus cost {"+( te - ts) +"} ms");
        //concat拼接字符串方式
        String s2 = "";
        long ts2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s2 = s2.concat(String.valueOf(i));
        }
        long te2 = System.currentTimeMillis();
        System.out.println("concat cost {"+(te2 - ts2)+"} ms");
        //StringUtils.join拼接字符串方式
        List<String> list = new ArrayList<String>();
        long ts3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }
        StringUtils.join(list, "");
        long te3 = System.currentTimeMillis();
        System.out.println("StringUtils.join cost {"+(te3 - ts3)+"} ms");
        //StringBuffer拼接字符串方式
        StringBuffer sb = new StringBuffer();
        long ts4 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te4 = System.currentTimeMillis();
        System.out.println("StringBuffer cost {"+(te4 - ts4)+"} ms");
        //StringBuilder拼接字符串方式
        StringBuilder sb5 = new StringBuilder();
        long ts5 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb5.append(String.valueOf(i));
        }
        sb5.toString();
        long te5 = System.currentTimeMillis();
        System.out.println("StringBuilder cost {"+(te5 - ts5)+"} ms");

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);
        System.out.println(x.equals(y));
    }
}
