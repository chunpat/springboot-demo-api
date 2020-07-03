package com.chunpat.fengxiuapi.model;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private int id;
    private String openid;
    private String nickname;
    private Integer unifyUid;
    private String email;
    private String password;
    private String mobile;
    private Object wxProfile;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getUnifyUid() {
        return unifyUid;
    }

    public void setUnifyUid(Integer unifyUid) {
        this.unifyUid = unifyUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getWxProfile() {
        return wxProfile;
    }

    public void setWxProfile(Object wxProfile) {
        this.wxProfile = wxProfile;
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
        User user = (User) o;
        return id == user.id &&
                Objects.equals(openid, user.openid) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(unifyUid, user.unifyUid) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(wxProfile, user.wxProfile) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(updateTime, user.updateTime) &&
                Objects.equals(deleteTime, user.deleteTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openid, nickname, unifyUid, email, password, mobile, wxProfile, createTime, updateTime, deleteTime);
    }
}
