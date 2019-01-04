package com.kcsj.wzcl.bean;

public class Operation {
    private Integer id;

    private Integer vioId;

    private String adminName;

    private String content;

    private String description;
    public Operation(Integer id, Integer vioId, String adminName, String content, String description) {
        this.id = id;
        this.vioId = vioId;
        this.adminName = adminName;
        this.content = content;
        this.description = description;
    }

    public Operation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVioId() {
        return vioId;
    }

    public void setVioId(Integer vioId) {
        this.vioId = vioId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}