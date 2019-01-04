package com.kcsj.wzcl.bean;

public class MyToken {
    /**
     * 登陆角色
     */
    private String role;
    /**
     * 登陆用户名
     */
    private String username;
    /**
     * 过期时间
     */
    private String expireTime;
    public MyToken() {
    }

    public MyToken(String role, String username, String expireTime) {
        this.role = role;
        this.username = username;
        this.expireTime = expireTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
