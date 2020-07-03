package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class SaleExplain {
    private int id;
    private Byte fixed;
    private String text;
    private Integer spuId;
    private Integer index;
    private Integer replaceId;
    private Timestamp createTime;
    private Timestamp deleteTime;
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getFixed() {
        return fixed;
    }

    public void setFixed(Byte fixed) {
        this.fixed = fixed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getReplaceId() {
        return replaceId;
    }

    public void setReplaceId(Integer replaceId) {
        this.replaceId = replaceId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleExplain that = (SaleExplain) o;
        return id == that.id &&
                Objects.equals(fixed, that.fixed) &&
                Objects.equals(text, that.text) &&
                Objects.equals(spuId, that.spuId) &&
                Objects.equals(index, that.index) &&
                Objects.equals(replaceId, that.replaceId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(deleteTime, that.deleteTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fixed, text, spuId, index, replaceId, createTime, deleteTime, updateTime);
    }
}
