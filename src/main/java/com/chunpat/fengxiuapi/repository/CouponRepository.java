package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.core.LocalUser;
import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
//    select c from Coupon c
//    join c.categoryList cl
//    join Activity ac on ac.id = c.activityId
//    and ac.online = 1
//    and ac.startTime < :nowdate
//    and ac.endTime > :nowdate
//    where cl.id = :cid
    @Query("select c from Coupon c \n" +
            "join CouponCategory coupon_category on coupon_category.couponId = c.id\n" +
            "join Category category on category.id = coupon_category.categoryId\n" +
            "join Activity ac on ac.id = c.activityId \n" +
            "and ac.online = 1 \n" +
            "and ac.startTime < :nowdate\n" +
            "and ac.endTime > :nowdate\n" +
            "where category.id = :cid")
    List<Coupon> findAllByCategory(Long cid, Date nowdate);

    List<Coupon> findAllByWholeStore(Boolean wholeStore);

    Optional<Coupon> findFirstById(Long id);

    @Query("select c from Coupon c \n" +
            "join UserCoupon user_coupon on user_coupon.couponId = c.id\n" +
            "and user_coupon.userId = :uid\n" +
            "and user_coupon.status = :status\n")
    List<Coupon> findByStatus(Long uid,Integer status);
}
