package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Coupon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CouponPureVo {
    private Long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
    private Integer type;
    private Integer valitiy;
    private Long activityId;
    private String remark;
    private Boolean wholeStore;

    public CouponPureVo(Coupon coupon) {
        BeanUtils.copyProperties(coupon,this);
    }

    public static List<CouponPureVo> getList(List<Coupon> coupons) {
        return coupons.stream().map(CouponPureVo::new).collect(Collectors.toList());
    }
}
