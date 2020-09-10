package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class OrderPureVo extends Order{
    public OrderPureVo(Order order) {
        BeanUtils.copyProperties(order,this);
    }
}
