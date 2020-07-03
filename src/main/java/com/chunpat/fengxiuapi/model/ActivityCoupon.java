package com.chunpat.fengxiuapi.model;

import java.util.Objects;

public class ActivityCoupon {
    private int id;
    private int couponId;
    private int activityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityCoupon that = (ActivityCoupon) o;
        return id == that.id &&
                couponId == that.couponId &&
                activityId == that.activityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, couponId, activityId);
    }
}
