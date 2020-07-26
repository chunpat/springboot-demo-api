package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Coupon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ActivityCouponPureVo extends ActivityPureVo{
    private List<CouponPureVo> coupons;

    public ActivityCouponPureVo(Activity activity) {
        super(activity);
        this.coupons = activity.getCouponList().stream().map(CouponPureVo::new).collect(Collectors.toList());
    }
}
