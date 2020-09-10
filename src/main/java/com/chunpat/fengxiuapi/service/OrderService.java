package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.Logic.PlaceOrderChecker;
import com.chunpat.fengxiuapi.core.enumeration.OrderStatus;
import com.chunpat.fengxiuapi.core.money.HalfUpDiscount;
import com.chunpat.fengxiuapi.dto.OrderDto;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.model.Order;
import com.chunpat.fengxiuapi.repository.OrderRepository;
import com.chunpat.fengxiuapi.util.Common;
import com.chunpat.fengxiuapi.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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

    @Value("${missyou.payTimeLimit}")
    private int payTimeLimit;

    //下单
    @Transactional
    public Long placeOrder(Long uid, OrderDto orderDto, PlaceOrderChecker placeOrderChecker) {
        //todo 下单
        //过期时间
        Calendar now = Calendar.getInstance();
        Date expireTime = (Common.expireTime(now,this.payTimeLimit)).getTime();
        Date createTime = (Common.expireTime(now,this.payTimeLimit)).getTime();
        Order order = Order.builder()
            .userId(uid)
            .orderNo(OrderUtil.getOrderCode(uid.intValue()))
            .totalPrice(orderDto.getTotalPrice())
            .finalTotalPrice(orderDto.getFinalTotalPrice())
            .snapTitle(placeOrderChecker.snapTitle())
            .snapImg(placeOrderChecker.snapImg())
            .expireTime(expireTime)
            .status(OrderStatus.UNPAID.getValue()).build();

        order.setSnapItems(placeOrderChecker.snapItems());
        order.setCreateTime(createTime);
        order.setSnapAddress(orderDto.getAddress());

        //下单
        this.orderRepository.save(order);

        //核销库存
        this.reduceStock(placeOrderChecker);

        //核销优惠券
        if(orderDto.getCouponId() != null){
            this.writeOffConpon(uid,orderDto.getCouponId(),order.getId());
        }
        return order.getId();
    }

    //检测
    public void isOk(Long uid, PlaceOrderChecker placeOrderChecker) {
        placeOrderChecker.isOK(uid,this.couponService,this.halfUpDiscount);
    }

    //核销库存
    public void reduceStock(PlaceOrderChecker placeOrderChecker) {
        placeOrderChecker.snapItems().forEach(orderDetail -> {
           this.skuService.reduceStock(orderDetail.getSkuId(),orderDetail.getCount());
        });
    }

    //核销优惠券
    public void writeOffConpon(Long uid, Long couponId, Long orderId) {
        this.couponService.writeOffConpon(uid,couponId,orderId);
    }

    /**
     * detail
     * @param uid
     * @param orderId
     * @return
     */
    public Order getDetail(Long uid, Long orderId) {
        Optional<Order> order = this.orderRepository.findFirstByUserIdAndId(uid,orderId);
        order.orElseThrow(()-> new ParameterException(50009));
        return order.get();
    }

    public Page<Order> getByStatus(Long uid, Integer status,Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return this.orderRepository.findAllByStatus(uid,status,page);
    }

    /**
     * @param uid
     * @param pageNum
     * @param size
     * @return
     */
    public Page<Order> getAllByUserId(Long uid,Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return this.orderRepository.findAllByUserId(uid,page);
    }
}
