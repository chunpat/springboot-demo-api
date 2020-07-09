package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.model.Theme;
import com.chunpat.fengxiuapi.service.ThemeService;
import com.chunpat.fengxiuapi.util.BeanMapperUtils;
import com.chunpat.fengxiuapi.util.Common;
import com.chunpat.fengxiuapi.vo.ThemePureVo;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theme")
@Validated
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @GetMapping("by/names")
    public List<ThemePureVo> getByName(@NotBlank String names){
        Optional<List<Theme>> themeList = themeService.getByNames(names);
        return Common.list2VoList(themeList.get(),ThemePureVo.class);
    }

    @GetMapping("name/{name}/with_spu")
    public Optional<Theme> getWithSpuByName(@PathVariable @NotBlank String name){
        Optional<Theme> theme = themeService.getWithSpuByName(name);
        theme.orElseThrow(()->new NotFoundException(10002));
        return theme;
    }
}
