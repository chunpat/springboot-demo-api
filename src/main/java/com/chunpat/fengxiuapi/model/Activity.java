package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null")
public class Activity extends BaseEntity{
    private String title;
    private String description;
    private Date startTime;
    private Date endTime;
    private String remark;
    private Byte online;
    private String entranceImg;
    private String internalTopImg;
    private String name;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "activityCoupon",joinColumns = @JoinColumn(name = "activityId"),inverseJoinColumns = @JoinColumn(name = "couponId"))
    private List<Coupon> couponList;

}
