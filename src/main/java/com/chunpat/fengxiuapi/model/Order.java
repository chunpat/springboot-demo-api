package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class Order extends BaseEntity{
    private String orderNo;
    private Integer userId;
    private BigDecimal totalPrice;
    private Integer totalCount;
    private String snapImg;
    private String snapTitle;
    private Object snapItems;
    private Object snapAddress;
    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Byte status;
}
