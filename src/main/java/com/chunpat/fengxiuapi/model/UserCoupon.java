package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class UserCoupon {
    private int id;
    private int userId;
    private int couponId;
    private byte status;
    private Timestamp createTime;
    private Integer orderId;
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCoupon that = (UserCoupon) o;
        return id == that.id &&
                userId == that.userId &&
                couponId == that.couponId &&
                status == that.status &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, couponId, status, createTime, orderId, updateTime);
    }
}
