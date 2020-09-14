package com.chunpat.fengxiuapi.v1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Value("${chunpat.version}")
    private String version;

    @Value("${chunpat.name}")
    private String name;

    @GetMapping()
    public Map<String,String> version(){
        Map<String,String> map = new HashMap<>();
        map.put("version",this.version);
        map.put("name",this.name);
        return map;
    }
}
