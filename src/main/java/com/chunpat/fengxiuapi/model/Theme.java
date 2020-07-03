package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Theme {
    private int id;
    private String title;
    private String description;
    private String name;
    private Timestamp createTime;
    private String tplName;
    private Timestamp updateTime;
    private Timestamp deleteTime;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Byte online;

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

    public String getTplName() {
        return tplName;
    }

    public void setTplName(String tplName) {
        this.tplName = tplName;
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

    public String getEntranceImg() {
        return entranceImg;
    }

    public void setEntranceImg(String entranceImg) {
        this.entranceImg = entranceImg;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getInternalTopImg() {
        return internalTopImg;
    }

    public void setInternalTopImg(String internalTopImg) {
        this.internalTopImg = internalTopImg;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public Byte getOnline() {
        return online;
    }

    public void setOnline(Byte online) {
        this.online = online;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return id == theme.id &&
                Objects.equals(title, theme.title) &&
                Objects.equals(description, theme.description) &&
                Objects.equals(name, theme.name) &&
                Objects.equals(createTime, theme.createTime) &&
                Objects.equals(tplName, theme.tplName) &&
                Objects.equals(updateTime, theme.updateTime) &&
                Objects.equals(deleteTime, theme.deleteTime) &&
                Objects.equals(entranceImg, theme.entranceImg) &&
                Objects.equals(extend, theme.extend) &&
                Objects.equals(internalTopImg, theme.internalTopImg) &&
                Objects.equals(titleImg, theme.titleImg) &&
                Objects.equals(online, theme.online);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, name, createTime, tplName, updateTime, deleteTime, entranceImg, extend, internalTopImg, titleImg, online);
    }
}
