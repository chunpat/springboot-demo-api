package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.bo.OrderMessageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponBackService {
    @Autowired
    CouponService couponService;

    /**
     * 回退优惠券
     * @param orderMessageBO
     */
    @EventListener
    @Transactional
    public void couponBack(OrderMessageBO orderMessageBO){
        if(orderMessageBO.getCouponId() != 0){
            this.couponService.backConpon(
                orderMessageBO.getUserId(),
                orderMessageBO.getCouponId(),
                orderMessageBO.getOrderId()
            );
        }
    }

    @EventListener
    public void test(OrderMessageBO orderMessageBO){
        System.out.println("56666");
    }
}
