package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
