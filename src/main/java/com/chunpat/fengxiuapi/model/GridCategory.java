package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class GridCategory {
    private int id;
    private String title;
    private String img;
    private String name;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private Integer categoryId;
    private Integer rootCategoryId;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getRootCategoryId() {
        return rootCategoryId;
    }

    public void setRootCategoryId(Integer rootCategoryId) {
        this.rootCategoryId = rootCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCategory that = (GridCategory) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(img, that.img) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(deleteTime, that.deleteTime) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(rootCategoryId, that.rootCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, img, name, createTime, updateTime, deleteTime, categoryId, rootCategoryId);
    }
}
