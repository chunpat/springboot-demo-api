package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoryPureVo {
    private String name;
    private String description;
    private Boolean isRoot;
    private Integer parentId;
    private String img;
    private Integer index;
    private Integer level;
}
