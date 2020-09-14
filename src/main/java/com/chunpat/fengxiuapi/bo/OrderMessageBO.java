package com.chunpat.fengxiuapi.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMessageBO {
    private Long orderId;
    private Long couponId;
    private Long userId;

    public OrderMessageBO(String message){
        String[] strings = message.split("-");
        this.orderId = Long.valueOf(strings[0]);
        this.userId = Long.valueOf(strings[1]);
        this.couponId = Long.valueOf(strings[2]);
    }
}
