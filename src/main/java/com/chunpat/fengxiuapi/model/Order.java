package com.chunpat.fengxiuapi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class Order {
    private int id;
    private String orderNo;
    private Integer userId;
    private BigDecimal totalPrice;
    private Integer totalCount;
    private Timestamp createTime;
    private Timestamp deleteTime;
    private Timestamp updateTime;
    private String snapImg;
    private String snapTitle;
    private Object snapItems;
    private Object snapAddress;
    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Byte status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getSnapImg() {
        return snapImg;
    }

    public void setSnapImg(String snapImg) {
        this.snapImg = snapImg;
    }

    public String getSnapTitle() {
        return snapTitle;
    }

    public void setSnapTitle(String snapTitle) {
        this.snapTitle = snapTitle;
    }

    public Object getSnapItems() {
        return snapItems;
    }

    public void setSnapItems(Object snapItems) {
        this.snapItems = snapItems;
    }

    public Object getSnapAddress() {
        return snapAddress;
    }

    public void setSnapAddress(Object snapAddress) {
        this.snapAddress = snapAddress;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public BigDecimal getFinalTotalPrice() {
        return finalTotalPrice;
    }

    public void setFinalTotalPrice(BigDecimal finalTotalPrice) {
        this.finalTotalPrice = finalTotalPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(orderNo, order.orderNo) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(totalCount, order.totalCount) &&
                Objects.equals(createTime, order.createTime) &&
                Objects.equals(deleteTime, order.deleteTime) &&
                Objects.equals(updateTime, order.updateTime) &&
                Objects.equals(snapImg, order.snapImg) &&
                Objects.equals(snapTitle, order.snapTitle) &&
                Objects.equals(snapItems, order.snapItems) &&
                Objects.equals(snapAddress, order.snapAddress) &&
                Objects.equals(prepayId, order.prepayId) &&
                Objects.equals(finalTotalPrice, order.finalTotalPrice) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNo, userId, totalPrice, totalCount, createTime, deleteTime, updateTime, snapImg, snapTitle, snapItems, snapAddress, prepayId, finalTotalPrice, status);
    }
}
