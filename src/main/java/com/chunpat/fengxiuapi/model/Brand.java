package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Brand {
    private int id;
    private String name;
    private String description;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Brand brand = (Brand) o;
        return id == brand.id &&
                Objects.equals(name, brand.name) &&
                Objects.equals(description, brand.description) &&
                Objects.equals(createTime, brand.createTime) &&
                Objects.equals(updateTime, brand.updateTime) &&
                Objects.equals(deleteTime, brand.deleteTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createTime, updateTime, deleteTime);
    }
}
