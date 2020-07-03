package com.chunpat.fengxiuapi.model;

import java.util.Objects;

public class CouponCategory {
    private int id;
    private int categoryId;
    private int couponId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponCategory that = (CouponCategory) o;
        return id == that.id &&
                categoryId == that.categoryId &&
                couponId == that.couponId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, couponId);
    }
}
