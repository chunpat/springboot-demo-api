package com.chunpat.fengxiuapi.core.money;

import java.math.BigDecimal;

public interface IMoneyDiscount {
    public BigDecimal discount(BigDecimal originMoney,BigDecimal discount);
}
