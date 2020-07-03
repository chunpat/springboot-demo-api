package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Activity {
    private int id;
    private String title;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String remark;
    private Byte online;
    private String entranceImg;
    private String internalTopImg;
    private String name;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getOnline() {
        return online;
    }

    public void setOnline(Byte online) {
        this.online = online;
    }

    public String getEntranceImg() {
        return entranceImg;
    }

    public void setEntranceImg(String entranceImg) {
        this.entranceImg = entranceImg;
    }

    public String getInternalTopImg() {
        return internalTopImg;
    }

    public void setInternalTopImg(String internalTopImg) {
        this.internalTopImg = internalTopImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id &&
                Objects.equals(title, activity.title) &&
                Objects.equals(description, activity.description) &&
                Objects.equals(startTime, activity.startTime) &&
                Objects.equals(endTime, activity.endTime) &&
                Objects.equals(createTime, activity.createTime) &&
                Objects.equals(updateTime, activity.updateTime) &&
                Objects.equals(deleteTime, activity.deleteTime) &&
                Objects.equals(remark, activity.remark) &&
                Objects.equals(online, activity.online) &&
                Objects.equals(entranceImg, activity.entranceImg) &&
                Objects.equals(internalTopImg, activity.internalTopImg) &&
                Objects.equals(name, activity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, startTime, endTime, createTime, updateTime, deleteTime, remark, online, entranceImg, internalTopImg, name);
    }
}
