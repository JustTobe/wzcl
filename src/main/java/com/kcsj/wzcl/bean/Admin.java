package com.kcsj.wzcl.bean;

public class Admin {
    private String adminName;

    private String password;

    private String type;

    private String userName;

    public Admin(String adminName, String password, String type, String userName) {
        this.adminName = adminName;
        this.password = password;
        this.type = type;
        this.userName = userName;
    }

    public Admin() {
        super();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}