package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.model.Theme;
import com.chunpat.fengxiuapi.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theme")
@Validated
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @GetMapping("by/names")
    public Optional<List<Theme>> getByName(@NotBlank String names){
        return themeService.getByNames(names);
    }

    @GetMapping("name/{name}/with_spu")
    public Optional<Theme> getWithSpuByName(@PathVariable @NotBlank String name){
        Optional<Theme> theme = themeService.getWithSpuByName(name);
        theme.orElseThrow(()->new NotFoundException(10002));
        return theme;
    }
}
