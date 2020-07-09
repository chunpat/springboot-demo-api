package com.chunpat.fengxiuapi.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ListDozer<T, K>{
    @SuppressWarnings("unchecked")
    public List<T> ListDozer(List<T> list, Class<K> KClass) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> klist = new ArrayList<>();
        List<T> tlist = list;
        tlist.forEach(v -> {
            K k = mapper.map(v, KClass);
            klist.add(k);
        });
        return tlist;
    }
}
