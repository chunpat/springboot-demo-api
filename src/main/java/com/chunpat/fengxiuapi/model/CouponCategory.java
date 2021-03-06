package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class CouponCategory{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int categoryId;
    private int couponId;
}
