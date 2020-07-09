package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Spu extends BaseEntity{
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

//    @ManyToMany(fetch= FetchType.EAGER)
//    @JoinTable(name = "sku_spec",joinColumns = @JoinColumn(name = "spu_id"),inverseJoinColumns = @JoinColumn(name = "sku_id"))
//    private List<SkuSpec> skuList;
    @OneToMany(fetch= FetchType.EAGER)
    @JoinColumn(name = "spuId")
    private List<Sku> skuList;

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "spuId")
    private List<SpuDetailImg> spuDetailImgList;

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "spuId")
    private List<SpuImg> spuImgList;
}
