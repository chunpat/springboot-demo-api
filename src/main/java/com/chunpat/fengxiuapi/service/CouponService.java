package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.core.enumeration.CouponStatus;
import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Coupon;
import com.chunpat.fengxiuapi.model.UserCoupon;
import com.chunpat.fengxiuapi.repository.ActivityRepository;
import com.chunpat.fengxiuapi.repository.CouponRepository;
import com.chunpat.fengxiuapi.repository.UserCouponRepository;
import com.chunpat.fengxiuapi.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CouponService {
    @Autowired
    CouponRepository couponRepository;
    @Autowired
    UserCouponRepository userCouponRepository;

    @Autowired
    ActivityRepository activityRepository;

    public List<Coupon> findAllByCategory(Long cid){
        Date nowdate = new Date();
        return this.couponRepository.findAllByCategory(cid,nowdate);
    }

    //获取全场圈
    public List<Coupon> findAllIsWholeStore(){
        return this.couponRepository.findAllByWholeStore(Boolean.TRUE);
    }

    //获取我的卷
    public List<Coupon> findAvailable(Long uid){
        Date now = new Date();
        return this.couponRepository.findByStatus(uid, CouponStatus.AVAILABLE.getValue(),now);
    }
    public List<Coupon> findUse(Long uid){
        Date now = new Date();
        return this.couponRepository.findByStatus(uid, CouponStatus.USED.getValue(),now);
    }
    public List<Coupon> findOutDate(Long uid){
        Date now = new Date();
        return this.couponRepository.findOutDate(uid, CouponStatus.AVAILABLE.getValue(),now);
    }

    //获取卷
    public void collect(Long uid,Long id){
        /**
         * 1、是否存在
         * 2、是否领取过
         * 3、活动有效期
         * 4、写入数据
         */
        //1、是否存在
        this.couponRepository.findFirstById(id).orElseThrow(NotFoundException::new);
        //2、是否领取过
        Optional<UserCoupon>  oldUserCoupon = this.userCouponRepository.findFirstByCouponIdAndUserId(id,uid);
        if(oldUserCoupon.isPresent()){
            throw new ParameterException(40006);
        }

        //3、活动有效期
        Optional<Activity>  activity = this.activityRepository.findFirstByCouponListId(id);
        activity.orElseThrow(NotFoundException::new);
        Date now = new Date();
        Boolean isIn = Common.isInTimeLine(now,activity.get().getStartTime(),activity.get().getEndTime());
        if(!isIn){
            throw new ParameterException(40007);
        }

        //4、写入数据
        UserCoupon userCouponNew = UserCoupon
                .builder()
                .userId(uid)
                .couponId(id)
                .status(CouponStatus.AVAILABLE.getValue())
                .createTime(now)
                .build();
        this.userCouponRepository.save( userCouponNew);
    }
}
