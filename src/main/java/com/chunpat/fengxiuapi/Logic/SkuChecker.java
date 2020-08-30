package com.chunpat.fengxiuapi.Logic;

import com.chunpat.fengxiuapi.dto.SkuInfoDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 1、sku是否存在
 * 2、sku价格判断 最终价格
 */
public class SkuChecker {
    private List<SkuInfoDto> skuInfoList;
    private BigDecimal totalPrice;

    public SkuChecker(List<SkuInfoDto> skuInfoList, BigDecimal totalPrice) {
        this.skuInfoList = skuInfoList;
        this.totalPrice = totalPrice;
    }

    public void isOk(){

    }


}
