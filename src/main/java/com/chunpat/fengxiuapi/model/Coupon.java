package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Coupon extends BaseEntity{
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

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "couponCategory",joinColumns = @JoinColumn(name = "couponId"),inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> categoryList;
}
