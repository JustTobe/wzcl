package com.kcsj.wzcl.bean;

public class Regular {
    private Integer id;

    private String name;

    private String serious;

    private String code;

    public Regular(Integer id, String name, String serious, String code) {
        this.id = id;
        this.name = name;
        this.serious = serious;
        this.code = code;
    }
    public Regular() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSerious() {
        return serious;
    }

    public void setSerious(String serious) {
        this.serious = serious == null ? null : serious.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}