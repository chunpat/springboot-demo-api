package com.chunpat.fengxiuapi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class Coupon {
    private int id;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
    private short type;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private Integer valitiy;
    private Integer activityId;
    private String remark;
    private Byte wholeStore;

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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
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

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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

    public Integer getValitiy() {
        return valitiy;
    }

    public void setValitiy(Integer valitiy) {
        this.valitiy = valitiy;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getWholeStore() {
        return wholeStore;
    }

    public void setWholeStore(Byte wholeStore) {
        this.wholeStore = wholeStore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return id == coupon.id &&
                type == coupon.type &&
                Objects.equals(title, coupon.title) &&
                Objects.equals(startTime, coupon.startTime) &&
                Objects.equals(endTime, coupon.endTime) &&
                Objects.equals(description, coupon.description) &&
                Objects.equals(fullMoney, coupon.fullMoney) &&
                Objects.equals(minus, coupon.minus) &&
                Objects.equals(rate, coupon.rate) &&
                Objects.equals(createTime, coupon.createTime) &&
                Objects.equals(updateTime, coupon.updateTime) &&
                Objects.equals(deleteTime, coupon.deleteTime) &&
                Objects.equals(valitiy, coupon.valitiy) &&
                Objects.equals(activityId, coupon.activityId) &&
                Objects.equals(remark, coupon.remark) &&
                Objects.equals(wholeStore, coupon.wholeStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, startTime, endTime, description, fullMoney, minus, rate, type, createTime, updateTime, deleteTime, valitiy, activityId, remark, wholeStore);
    }
}
