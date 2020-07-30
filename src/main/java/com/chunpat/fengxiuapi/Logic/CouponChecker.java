package com.chunpat.fengxiuapi.Logic;

import com.chunpat.fengxiuapi.core.enumeration.CouponType;
import com.chunpat.fengxiuapi.core.money.IMoneyDiscount;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.model.Coupon;
import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.model.UserCoupon;
import com.chunpat.fengxiuapi.util.Common;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 1、使用时间判断
 * 2、最终价格计算与比较
 * 3、是否能使用
 */
public class CouponChecker {
    private Coupon coupon;
    private UserCoupon userCoupon;
    private IMoneyDiscount IMoneyDiscount;

    public CouponChecker(Coupon coupon, UserCoupon userCoupon,IMoneyDiscount IMoneyDiscount) {
        this.coupon = coupon;
        this.userCoupon = userCoupon;
        this.IMoneyDiscount = IMoneyDiscount;
    }

    public Boolean isOK(){
        Date now = new Date();
        if(!Common.isInTimeLine(now,this.coupon.getStartTime(),this.coupon.getEndTime())){
            throw new ParameterException(40008);
        };
        return true;
    }

    /**
     *
     * @param orderFinalTotalPrice 前端价格
     * @param serverTotalPrice 服务器sku count* price 累加的价格
     * @return
     */
    public Boolean finalTotalPriceIsOK(BigDecimal orderFinalTotalPrice,BigDecimal serverTotalPrice){
        if(orderFinalTotalPrice.compareTo(BigDecimal.valueOf(0)) <= 0 && serverTotalPrice.compareTo(BigDecimal.valueOf(0)) <= 0){
            throw new ParameterException(10000);
        }
        switch (CouponType.toType(this.coupon.getType())){
            case FULL_OFF:
                serverTotalPrice = this.IMoneyDiscount.discount(serverTotalPrice,this.coupon.getFullMoney());
                if(orderFinalTotalPrice.compareTo(serverTotalPrice) != 0){
                    throw new ParameterException(40009);
                }
                break;
            case FULL_MINUS:
            case NO_THRESHOLD:
                serverTotalPrice = serverTotalPrice.subtract(this.coupon.getMinus());
                if(orderFinalTotalPrice.compareTo(serverTotalPrice) != 0){
                    throw new ParameterException(40009);
                }
                break;
            default:
                throw new ParameterException(40010);
        }
        return true;
    }

    public void canBeUsed() {
    }

    
}
