package com.kcsj.wzcl.bean;

import java.util.List;

public class SearchParam {
    int  index;
    String  order;


    private List<ParamBody> operators;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<ParamBody> getOperators() {
        return operators;
    }

    public void setOperators(List<ParamBody> operators) {
        this.operators = operators;
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "index=" + index +
                ", order='" + order + '\'' +
                ", operators=" + operators +
                '}';
    }
}
