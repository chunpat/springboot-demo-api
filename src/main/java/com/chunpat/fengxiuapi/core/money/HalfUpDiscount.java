package com.chunpat.fengxiuapi.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HalfUpDiscount implements IMoneyDiscount{
    @Override
    public BigDecimal discount(BigDecimal originMoney, BigDecimal discount) {
        BigDecimal finalMoney = originMoney.multiply(discount);
        return  finalMoney.setScale(2, RoundingMode.HALF_UP);
    }
}
