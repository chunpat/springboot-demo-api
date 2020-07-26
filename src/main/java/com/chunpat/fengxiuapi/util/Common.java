package com.chunpat.fengxiuapi.util;

import com.chunpat.fengxiuapi.bo.PageCounter;
import com.chunpat.fengxiuapi.exception.ServerInnerException;
import com.chunpat.fengxiuapi.vo.ThemePureVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Common {

    //分页参数转换成PageCounter
    public static PageCounter convertToPageParameter(Integer start, Integer count){
        Integer page = start / count;
        PageCounter pageCounter = PageCounter.builder().page(page).count(count).build();
        return pageCounter;
    }

    //vo list copy
    public static <K, T> List<K> list2VoList(List<T> list, Class<K> KClass){
        if(list.isEmpty()){
            return null;
        }
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> vo = new ArrayList<>();
        list.forEach(v -> {
            K k = mapper.map(v, KClass);
            vo.add(k);
        });
        return vo;
    }

    //是否在时间内
    public static Boolean isInTimeLine(Date now, Date startDate,Date endData){
        if(!now.after(startDate) || !now.before(endData)){
            return false;
        }
        return true;
    }
}
