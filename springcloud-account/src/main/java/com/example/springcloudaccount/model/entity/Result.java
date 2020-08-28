package com.example.springcloudaccount.model.entity;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-12 11:07
 **/
public class Result<T> {

    private int status;
    private String message;
    private T object;

    public Result() {
    }

    public Result(int status, String message, T object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
    //创建status枚举类
    public enum status{
        SUCCESS(200),FAILED(500);
        public int status;

        status(int status) {
            this.status = status;
        }
    }


}
