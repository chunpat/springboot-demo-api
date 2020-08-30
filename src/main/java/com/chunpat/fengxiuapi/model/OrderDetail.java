package com.chunpat.fengxiuapi.model;

import com.chunpat.fengxiuapi.dto.SkuInfoDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderDetail{
    private Long skuId;
//    private Long orderId;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private Integer count;
    private String img;
    private String title;
    private List<String> specsValue;

    public OrderDetail(Sku sku, SkuInfoDto skuInfoDto){
        this.skuId = sku.getSpuId();
//        this.orderId = 0L;
        this.price = sku.getActualPrice();
        this.totalPrice = sku.getActualPrice().multiply(new BigDecimal(skuInfoDto.getCount()));
        this.count = skuInfoDto.getCount();
        this.img = sku.getImg();
        this.title = sku.getTitle();
        this.specsValue = sku.getSpecsValue();
    }
}
