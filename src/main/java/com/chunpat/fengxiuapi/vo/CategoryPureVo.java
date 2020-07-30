package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Category;
import com.chunpat.fengxiuapi.model.Coupon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CategoryPureVo {
    private String name;
    private String description;
    private Boolean isRoot;
    private Integer parentId;
    private String img;
    private Integer index;
    private Integer level;

    public CategoryPureVo(Category category) {
        BeanUtils.copyProperties(category,this);
    }
}
