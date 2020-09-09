package com.chunpat.fengxiuapi.Logic;

import com.chunpat.fengxiuapi.core.money.IMoneyDiscount;
import com.chunpat.fengxiuapi.dto.OrderDto;
import com.chunpat.fengxiuapi.dto.SkuInfoDto;
import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.model.Coupon;
import com.chunpat.fengxiuapi.model.OrderDetail;
import com.chunpat.fengxiuapi.model.Sku;
import com.chunpat.fengxiuapi.model.UserCoupon;
import com.chunpat.fengxiuapi.service.CouponService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 1、sku和count验证。
 * 2、总价格验证
 * 3、优惠券验证
 */
public class PlaceOrderChecker {
    private List<Sku> serviceSkuList;
    private OrderDto orderDto;
    private List<SkuInfoDto> skuInfoDtoList;
    private Integer skuMaxLimit;
    private List<OrderDetail> orderDetail =  new ArrayList<>();

    public PlaceOrderChecker(List<Sku> serviceSkuList, OrderDto orderDto, Integer skuMaxLimit) {
        this.serviceSkuList = serviceSkuList;
        this.orderDto = orderDto;
        this.skuInfoDtoList = orderDto.getSkuInfoList();
        this.skuMaxLimit = skuMaxLimit;
    }

    public void isOK(Long uid, CouponService couponService,IMoneyDiscount halfUpDiscount){
        //sku数量验证
        skuNotOnSale(this.serviceSkuList.size(),this.skuInfoDtoList.size());

        BigDecimal serverTotalPrice = new BigDecimal(0);
        //这里一一对应，传数据进去与查出来的数据顺序一致
        for (int i = 0;i < this.serviceSkuList.size();i++){
            Sku serviceSku = this.serviceSkuList.get(i);
            SkuInfoDto sku = this.skuInfoDtoList.get(i);

            //是否下架
            this.skuIsSale(serviceSku);

            //是否售罄
            this.containSoldOutSku(serviceSku,sku);

            //是否超出限制
            this.beyondMaxSkuLimit(sku);

            //orderDetail数据
            this.orderDetail.add(new OrderDetail(serviceSku, sku));

            BigDecimal serviceSkuPrice = serviceSku.getActualPrice();
            BigDecimal serviceSkuCount = new BigDecimal(sku.getCount());
            serverTotalPrice = serverTotalPrice.add(serviceSkuPrice.multiply(serviceSkuCount));
        }

        if(this.orderDto.getCouponId() != null){
            Optional<Coupon> coupon = couponService.findById(this.orderDto.getCouponId());
            coupon.orElseThrow(()-> new NotFoundException(40004));
            Optional<UserCoupon> userCoupon = couponService.findFirstByCouponIdAndUserId(this.orderDto.getCouponId(),uid);
            userCoupon.orElseThrow(()-> new NotFoundException(50006));
            (new CouponChecker( coupon.get(),  userCoupon.get(), halfUpDiscount)).isOK(orderDto.getFinalTotalPrice(), serverTotalPrice);
        }
    }


    //sku数量验证
    public void skuNotOnSale(int serviceSkuCount,int userSkuCount){
        if(serviceSkuCount != userSkuCount){
            throw new ParameterException(50001);
        }
    }

    //下架验证
    public void skuIsSale(Sku serviceSku){
        if(serviceSku.getOnline() == 0){
            throw new ParameterException(50002);
        }
    }

    //售罄
    public void containSoldOutSku(Sku serviceSku,SkuInfoDto skuInfoDto){
        //购买数量验证
        if(serviceSku.getStock().compareTo(skuInfoDto.getCount()) < 0){
            throw new ParameterException(50003);
        }
    }

    //最大限制
    public void beyondMaxSkuLimit(SkuInfoDto skuInfoDto){
        //购买数量验证
        if(this.skuMaxLimit.compareTo(skuInfoDto.getCount()) < 0){
            throw new ParameterException(50003);
        }
    }

    /**
     * titl快照
     * @return String
     */
    public String snapTitle(){
        return this.serviceSkuList.get(0).getTitle();
    }

    /**
     * titl快照
     * @return String
     */
    public String snapImg(){
        return this.serviceSkuList.get(0).getImg();
    }

    /**
     * sku 快照
     * @return List<OrderDetail>
     */
    public List<OrderDetail> snapItems(){
        return this.orderDetail;
    }


}
