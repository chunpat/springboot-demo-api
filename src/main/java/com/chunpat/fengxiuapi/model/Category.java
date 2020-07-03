package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Category {
    private int id;
    private String name;
    private String description;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private byte isRoot;
    private Integer parentId;
    private String img;
    private Integer index;
    private Integer online;
    private Integer level;

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

    public byte getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(byte isRoot) {
        this.isRoot = isRoot;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                isRoot == category.isRoot &&
                Objects.equals(name, category.name) &&
                Objects.equals(description, category.description) &&
                Objects.equals(createTime, category.createTime) &&
                Objects.equals(updateTime, category.updateTime) &&
                Objects.equals(deleteTime, category.deleteTime) &&
                Objects.equals(parentId, category.parentId) &&
                Objects.equals(img, category.img) &&
                Objects.equals(index, category.index) &&
                Objects.equals(online, category.online) &&
                Objects.equals(level, category.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createTime, updateTime, deleteTime, isRoot, parentId, img, index, online, level);
    }
}
