package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Theme;
import com.chunpat.fengxiuapi.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Component
public class ThemeService{
    @Autowired
    ThemeRepository themeRepository;

    public Optional<List<Theme>> getByNames(String names){
        String[] strings = names.split(",");
        ArrayList<String> array = new ArrayList<>();
        for (int i=0;i<strings.length;i++){
            array.add(strings[i]);
        }
        List<Theme> theme;
        theme = this.themeRepository.findAllByNameIsIn(array);
        return Optional.of(theme);
    }

    public Optional<Theme> getWithSpuByName(String name){
        return this.themeRepository.findThemeByName(name);
    }
}
