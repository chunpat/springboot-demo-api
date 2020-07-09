package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Category;
import com.chunpat.fengxiuapi.model.Theme;
import com.chunpat.fengxiuapi.repository.CategoryRepository;
import com.chunpat.fengxiuapi.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Map<String,List<Category>> getAll(){
        List<Category> roots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
        List<Category> subs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);
        Map<String,List<Category>> map = new HashMap<>();
        map.put("subs",subs);
        map.put("roots",roots);
        return map;
    }
}
