package com.zzwch.manager.entry.ResultEntry;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public class BaseResult<T> {

    public BaseResult(int code, @NonNull String mess, @NotNull T o) {
       this.code = code;
       this.mess = mess;
       this.result =o;
    }

    private int code;
    private String mess;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
