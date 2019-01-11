package com.kcsj.wzcl.bean;

public class MessageRecord {
    private Integer id;

    private String email;

    private Long date;

    private Integer violationId;

    private String content;

    public MessageRecord(Integer id, String email, Long date, Integer violationId, String content) {
        this.id = id;
        this.email = email;
        this.date = date;
        this.violationId = violationId;
        this.content = content;
    }

    public MessageRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getViolationId() {
        return violationId;
    }

    public void setViolationId(Integer violationId) {
        this.violationId = violationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}