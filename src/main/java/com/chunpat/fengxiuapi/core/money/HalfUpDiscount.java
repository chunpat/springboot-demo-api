package com.chunpat.fengxiuapi.core.money;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class HalfUpDiscount implements IMoneyDiscount{
    @Override
    public BigDecimal discount(BigDecimal originMoney, BigDecimal discount) {
        BigDecimal finalMoney = originMoney.multiply(discount);
        return  finalMoney.setScale(2, RoundingMode.HALF_UP);
    }
}
