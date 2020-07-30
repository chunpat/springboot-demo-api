package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.core.LocalUser;
import com.chunpat.fengxiuapi.core.UnifyResponse;
import com.chunpat.fengxiuapi.core.annotation.ScopeLevel;
import com.chunpat.fengxiuapi.core.enumeration.CouponStatus;
import com.chunpat.fengxiuapi.exception.CreateSuccess;
import com.chunpat.fengxiuapi.model.Coupon;
import com.chunpat.fengxiuapi.model.CouponCategory;
import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.service.CouponService;
import com.chunpat.fengxiuapi.util.BeanMapperUtils;
import com.chunpat.fengxiuapi.vo.CouponCategoryPureVo;
import com.chunpat.fengxiuapi.vo.CouponPureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    CouponService couponService;

    @GetMapping("by/category/{cid}")
    public List<CouponPureVo> getByCategoryId(@PathVariable @NotBlank Long cid){
        List<Coupon> coupon = couponService.findAllByCategory(cid);
        return CouponPureVo.getList(coupon);
    }

    @GetMapping("whole_store")
    public List<CouponPureVo> getIsWholeStore(){
        List<Coupon> coupon = couponService.findAllIsWholeStore();
        return CouponPureVo.getList(coupon);
    }

    @GetMapping("myself/by/status/{status}")
    @ScopeLevel
    public List<CouponPureVo> getByStatus(@PathVariable @NotBlank Integer status){
        User user = LocalUser.getUser();
        List<Coupon> couponList = new ArrayList<>();
        switch (CouponStatus.toType(status)){
            case AVAILABLE:
                couponList = couponService.findAvailable(user.getId());
                break;
            case USED:
                couponList = couponService.findUse(user.getId());
                break;
            case OUTDATE:
                couponList = couponService.findOutDate(user.getId());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
        return CouponPureVo.getList(couponList);
    }

    @PostMapping("collect/{id}")
    @ScopeLevel
    public void collect(@PathVariable @NotBlank Long id){
        User user = LocalUser.getUser();
        couponService.collect(user.getId(),id);
        UnifyResponse.createSuccess();
    }

    @GetMapping("myself/available/with_category")
    @ScopeLevel
    public List<CouponCategoryPureVo> getMyCouponsWithCategory(){
        User user = LocalUser.getUser();
        List<Coupon> coupons = couponService.findAvailable(user.getId());
        return BeanMapperUtils.mapList(coupons,CouponCategoryPureVo.class);
    }
}
