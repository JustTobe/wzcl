package com.kcsj.wzcl.bean;

import java.util.Date;

/**
 * 发信模板中，需要填充的内容
 */
public class Message {
    /*
    亲爱的（张虎宇）（老师）：
        您好，
        您于（2016年10-10）在（区域）发生（酒驾）违章行为，您的车牌号为（111）。本次违章为您的第（3）次违章，扣除车辆通行信用分数（）
      分，您剩余的分数为（18）分.分数低于0分时，禁止进入电子科技大学校园内。
                                                                                           电子科技大学车辆管理中心
     */
    private String name;
    private String indentity;
    private String history;

    private Date date;
    private String area;
    private String type;
    private String plate;
    private int count;
    private boolean ban;

    public Message() {
    }

    public Message(Date date, String area, String type, String plate, int reduceNum, int remainNum) {
        this.date = date;
        this.area = area;
        this.type = type;
        this.plate = plate;
    }

    public Message(String name, String indentity, String history, Date date, String area, String type, String plate, int count, boolean ban) {
        this.name = name;
        this.indentity = indentity;
        this.history = history;
        this.date = date;
        this.area = area;
        this.type = type;
        this.plate = plate;
        this.count = count;
        this.ban = ban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndentity() {
        return indentity;
    }

    public void setIndentity(String indentity) {
        this.indentity = indentity;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }
}