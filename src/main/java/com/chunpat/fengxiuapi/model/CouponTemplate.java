package com.chunpat.fengxiuapi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class CouponTemplate {
    private int id;
    private String title;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal discount;
    private short type;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getFullMoney() {
        return fullMoney;
    }

    public void setFullMoney(BigDecimal fullMoney) {
        this.fullMoney = fullMoney;
    }

    public BigDecimal getMinus() {
        return minus;
    }

    public void setMinus(BigDecimal minus) {
        this.minus = minus;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponTemplate that = (CouponTemplate) o;
        return id == that.id &&
                type == that.type &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(fullMoney, that.fullMoney) &&
                Objects.equals(minus, that.minus) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(deleteTime, that.deleteTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, fullMoney, minus, discount, type, createTime, updateTime, deleteTime);
    }
}
