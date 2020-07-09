package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Sku;
import com.chunpat.fengxiuapi.model.Spec;
import com.chunpat.fengxiuapi.util.GenericAndJson;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class SkuSimplifyVo {
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private byte online;
    private String img;
    private String title;
    private Long spuId;

    private List<Spec> specs;
    private String code;
    private Integer stock;
    private Integer categoryId;
    private Integer rootCategoryId;
}
