package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.dto.PersonDto;
import com.chunpat.fengxiuapi.model.Tag;
import com.chunpat.fengxiuapi.service.TagService;
import com.chunpat.fengxiuapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("type/{type}")
    public List<Tag> getByType(@PathVariable @NotBlank Integer type){
        return tagService.getByType(type);
    }
}
