package com.chunpat.fengxiuapi.util;

import com.chunpat.fengxiuapi.bo.PageCounter;

public class Common {
    public static PageCounter convertToPageParameter(Integer start, Integer count){
        Integer page = start / count;
        PageCounter pageCounter = PageCounter.builder().page(page).count(count).build();
        return pageCounter;
    }
}
