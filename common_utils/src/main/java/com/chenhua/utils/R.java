package com.chenhua.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
public class R {
    private boolean success;
    private Integer code;
    private String message;
    private HashMap<String,Object> data=new HashMap<>();
    private R(){}
    public static R ok(){
        R r=new R();
        r.success=true;
        r.code= ResultCode.SUCCESS.getCode();
        r.message=ResultCode.SUCCESS.getMsg();
        return r;
    }
    public static R error(){
        R r=new R();
        r.success=false;
        r.code= ResultCode.UNKNOWN_ERROR.getCode();
        r.message=ResultCode.UNKNOWN_ERROR.getMsg();
        return r;
    }
    public R code(Integer code){
        this.code=code;
        return this;
    }
    public R data(HashMap<String,Object> map){
        this.data=map;
        return this;
    }
    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public R message(String msg){
        this.message=msg;
        return this;
    }

//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setData(HashMap<String, Object> data) {
//        this.data = data;
//    }
//
//    public HashMap<String, Object> getData() {
//        return data;
//    }
}

