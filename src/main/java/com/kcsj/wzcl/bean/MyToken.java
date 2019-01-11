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
    private String token;
    private String id;
    public MyToken() {
    }

    public MyToken(String role, String username ) {
        this.role = role;
        this.username = username;

    }

    public MyToken(String role, String username, String token, String id) {
        this.role = role;
        this.username = username;
        this.token = token;
        this.id = id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
