package org.seckill.dto;


import java.io.Serializable;

//所有ajax请求放回类型，封装json结果
public class SeckillResult<T> implements Serializable {

    private boolean success;
    private T data;
    private String error;


    public SeckillResult() {
    }

    //请求成功
    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    //请求失败
    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
