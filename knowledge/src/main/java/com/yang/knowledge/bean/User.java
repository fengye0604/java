package com.yang.knowledge.bean;

import java.util.Date;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private Date createTime;

    private String userStatus;

    private Date updateTime;

    public User(Integer userId, String username, String password, Date createTime, String userStatus, Date updateTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.userStatus = userStatus;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}