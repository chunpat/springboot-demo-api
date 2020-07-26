package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.core.LocalUser;
import com.chunpat.fengxiuapi.core.UnifyResponse;
import com.chunpat.fengxiuapi.core.annotation.ScopeLevel;
import com.chunpat.fengxiuapi.exception.CreateSuccess;
import com.chunpat.fengxiuapi.model.Coupon;
import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.service.CouponService;
import com.chunpat.fengxiuapi.vo.CouponPureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.validation.constraints.NotBlank;
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
        List<Coupon> coupon = couponService.findByStatus(user.getId(),status);
        return CouponPureVo.getList(coupon);
    }

    @PostMapping("collect/{id}")
    @ScopeLevel
    public void collect(@PathVariable @NotBlank Long id){
        User user = LocalUser.getUser();
        couponService.collect(user.getId(),id);
        UnifyResponse.createSuccess();
    }
}
