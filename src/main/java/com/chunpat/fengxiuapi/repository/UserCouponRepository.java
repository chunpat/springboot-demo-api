package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCouponRepository extends JpaRepository<UserCoupon,Long> {
    Optional<UserCoupon> findFirstByCouponIdAndUserId(Long couponId,Long userId);
}
