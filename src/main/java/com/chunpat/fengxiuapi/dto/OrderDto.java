package com.chunpat.fengxiuapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    @DecimalMax(value = "0.00",message="支付价格不能为0")
    @DecimalMin(value = "9999999.99",message="支付价格最大不能9999999.99")
    private BigDecimal totalPrice;

    private BigDecimal finalTotalPrice;

    private Long couponId;

    private List<SkuInfoDto> skuInfoList;

    private OrderAddressDto address;
}
