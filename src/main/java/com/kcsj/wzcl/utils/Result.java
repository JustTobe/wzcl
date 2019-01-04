package com.kcsj.wzcl.utils;



public class Result {

    /**
     * 状态码 200：成功
     *       100：失败
     */
    private int statusCode;

    private String description;

    /**
     * 返回的数据 类型为object
     */
    private Object data;


    public Result(){
        statusCode=0;
        this.description=null;
        this.data=null;
    }



    public static Result Success(){
        Result result=new Result();
        result.setStatusCode(200);

        System.out.println(result);
        return result;
    }
    public static Result Fail(){
        Result result=new Result();
        result.setStatusCode(100);
        return result;
    }
    public  static Result isSuccess(boolean bool){
        Result result=new Result();
        if(bool){
            result.setStatusCode(200);
        }else {
            result.setStatusCode(100);
        }
        return  result;

    }
    public static Result  add(Object object){

        Result result=new Result();
        result.setStatusCode(200);
        result.setData(object);
        return result;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setData(Object data) {

        this.data = data;
    }


    @Override
    public String toString() {
        return "Result{" +
                "statusCode=" + statusCode +
                ", description='" + description + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    public Object getData() {
        return data;
    }
}
