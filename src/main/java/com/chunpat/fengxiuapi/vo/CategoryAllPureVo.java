package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoryAllPureVo {
    private List<CategoryPureVo> roots;
    private List<CategoryPureVo> subs;

    public void CategoryAllPureVo(Map<String,List<Category>> map){
        this.roots = map.get("roots").stream().map(r->{return new CategoryPureVo();}).collect(Collectors.toList());
        this.subs = map.get("roots").stream().map(r->{return new CategoryPureVo();}).collect(Collectors.toList());
    }
}
