package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.Logic.PlaceOrderChecker;
import com.chunpat.fengxiuapi.core.enumeration.OrderStatus;
import com.chunpat.fengxiuapi.core.money.HalfUpDiscount;
import com.chunpat.fengxiuapi.dto.OrderDto;
import com.chunpat.fengxiuapi.model.Order;
import com.chunpat.fengxiuapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    SkuService skuService;

    @Autowired
    CouponService couponService;

    @Autowired
    HalfUpDiscount halfUpDiscount;

    @Autowired
    OrderRepository orderRepository;

    //下单
    public void placeOrder(Long uid, OrderDto orderDto, PlaceOrderChecker placeOrderChecker) {
        //todo 下单
        int value = OrderStatus.UNPAID.getValue();
        Order order = Order.builder()
            .userId(uid)
            .orderNo("6666666")
            .totalPrice(orderDto.getTotalPrice())
            .finalTotalPrice(orderDto.getFinalTotalPrice())
            .snapTitle(placeOrderChecker.snapTitle())
            .snapImg(placeOrderChecker.snapImg())
            .status(OrderStatus.UNPAID.getValue()).build();

        order.setSnapItems(placeOrderChecker.snapItems());
        order.setSnapAddress(orderDto.getAddress());

        this.orderRepository.save(order);

//        private String orderNo;
//        private Long userId;
//        private BigDecimal totalPrice;
//        private Integer totalCount;
//        private String snapImg;
//        private String snapTitle;
//        private String snapItems;
//        private String snapAddress;
//        private String prepayId;
//        private BigDecimal finalTotalPrice;
//        private Boolean status;
    }

    //检测
    public void isOk(Long uid, PlaceOrderChecker placeOrderChecker) {
        placeOrderChecker.isOK(uid,this.couponService,this.halfUpDiscount);
    }
}
