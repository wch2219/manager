package com.zzwch.manager.entry.ResultEntry;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public class BaseResult {

    public BaseResult(int code, @NonNull String mess, @NotNull Object o) {
       this.code = code;
       this.mess = mess;
       this.result =o;
    }

    private int code;
    private String mess;
    private Object result;

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

    public Object getObject() {
        return result;
    }

    public void setObject(Object object) {
        this.result = object;
    }
}
