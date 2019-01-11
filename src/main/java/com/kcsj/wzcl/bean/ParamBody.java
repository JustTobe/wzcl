package com.kcsj.wzcl.bean;

public class ParamBody {
    String keyword;

    String operator;

    String matchType;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    @Override
    public String toString() {
        return "ParamBody{" +
                "keyword='" + keyword + '\'' +
                ", operator='" + operator + '\'' +
                ", matchType='" + matchType + '\'' +
                '}';
    }
}
