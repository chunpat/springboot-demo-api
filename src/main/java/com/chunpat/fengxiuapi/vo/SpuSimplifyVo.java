package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Sku;
import com.chunpat.fengxiuapi.model.SpuDetailImg;
import com.chunpat.fengxiuapi.model.SpuImg;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpuSimplifyVo {
    private Long id;
    private String title;
    private String subtitle;
    private int categoryId;
    private Long rootCategoryId;
    private Boolean online;
    private String price;
    private Long sketchSpecId;
    private Long defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private Boolean isTest;
    private String spuThemeImg;
    private String forThemeImg;


    private List<SkuSimplifyVo> skuList;
    private List<SpuDetailImg> spuDetailImgList;
    private List<SpuImg> spuImgList;
}
