package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.OrderAddress;
import com.chunpat.fengxiuapi.model.OrderDetail;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderSimplifyVo {
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal totalPrice;
    private Integer totalCount;
    private String snapImg;
    private String snapTitle;
    private List<OrderDetail> snapItems;
    private OrderAddress snapAddress;
    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Integer status;
    private Date expireTime;


}
