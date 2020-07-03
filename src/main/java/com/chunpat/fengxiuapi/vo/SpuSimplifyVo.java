package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Sku;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpuSimplifyVo {
    private Long id;
    private String title;
    private String subtitle;

    private List<Sku> skuList;
}
