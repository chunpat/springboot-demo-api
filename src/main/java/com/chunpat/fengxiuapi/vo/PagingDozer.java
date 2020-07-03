package com.chunpat.fengxiuapi.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PagingDozer<T, K> extends Paging {
    @SuppressWarnings("unchecked")
    public PagingDozer(Page<T> tPage, Class<K> KClass) {
        this.init(tPage);
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> klist = new ArrayList<>();
        List<T> tlist = tPage.getContent();
        tlist.forEach(v -> {
            K k = mapper.map(v, KClass);
            klist.add(k);
        });
        this.setItems(klist);
    }
}
