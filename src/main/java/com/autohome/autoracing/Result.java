package com.autohome.autoracing;



public class Result {
    private static final int    DEFAULT_SUCCESS_CODE    = 0;
    private static final String DEFAULT_SUCCESS_MESSAGE = "success";

    private int code;

    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result successResult(Object data){
        return new Result(data);
    }


    public static  Result failedResult(int code, String message){
        return new Result(code, message);
    }

    public static  Result failedResult(String message){
        return new Result(500, message);
    }

    Result(Object data){
        this.code = DEFAULT_SUCCESS_CODE;
        this.message = DEFAULT_SUCCESS_MESSAGE;
        this.data = data;
    }

    Result(int code, String message){
        this.code = code;
        this.message = message;
    }
    public Result(){}
}
