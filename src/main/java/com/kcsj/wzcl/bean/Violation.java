package com.kcsj.wzcl.bean;

import java.util.Date;

public class Violation {
    private Integer id;

    private String plate;
    private String area;

    private String type;

    private String status;

    private Date date;

    private String vioPic;

    private String platePic;

    private Integer userId;

    public Violation(Integer id, String plate, String area, String type, String status, Date date, String vioPic, String platePic, Integer userId) {
        this.id = id;
        this.plate = plate;
        this.area = area;
        this.type = type;
        this.status = status;
        this.date = date;
        this.vioPic = vioPic;
        this.platePic = platePic;
        this.userId = userId;
    }

    public Violation() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVioPic() {
        return vioPic;
    }

    public void setVioPic(String vioPic) {
        this.vioPic = vioPic == null ? null : vioPic.trim();
    }

    public String getPlatePic() {
        return platePic;
    }

    public void setPlatePic(String platePic) {
        this.platePic = platePic == null ? null : platePic.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}