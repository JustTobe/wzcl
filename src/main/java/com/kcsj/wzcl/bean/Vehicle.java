package com.kcsj.wzcl.bean;

public class Vehicle {
    private Integer id;

    private String plate;

    private String name;

    private String phone;

    private String email;

    private String identityType;

    private Integer grade;

    private Integer count;

    public Vehicle(Integer id, String plate, String name, String phone, String email, String identityType, Integer grade, Integer count) {
        this.id = id;
        this.plate = plate;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.identityType = identityType;
        this.grade = grade;
        this.count = count;
    }

    public Vehicle() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}