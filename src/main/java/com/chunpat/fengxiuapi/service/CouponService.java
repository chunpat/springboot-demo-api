package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Coupon;
import com.chunpat.fengxiuapi.repository.ActivityRepository;
import com.chunpat.fengxiuapi.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CouponService {
    @Autowired
    CouponRepository couponRepository;

//    public Optional<Coupon> findAllB(String name){
////        return this.couponRepository.findByName(name);
//    }
}
