package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Tag {
    private int id;
    private String title;
    private String description;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private Timestamp createTime;
    private Byte highlight;
    private Byte type;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Byte getHighlight() {
        return highlight;
    }

    public void setHighlight(Byte highlight) {
        this.highlight = highlight;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id &&
                Objects.equals(title, tag.title) &&
                Objects.equals(description, tag.description) &&
                Objects.equals(updateTime, tag.updateTime) &&
                Objects.equals(deleteTime, tag.deleteTime) &&
                Objects.equals(createTime, tag.createTime) &&
                Objects.equals(highlight, tag.highlight) &&
                Objects.equals(type, tag.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, updateTime, deleteTime, createTime, highlight, type);
    }
}
