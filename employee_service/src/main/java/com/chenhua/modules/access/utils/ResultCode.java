package com.chenhua.modules.access.utils;

public enum ResultCode {
    //最基本
    SUCCESS(20000, "成功"),
    UNKNOWN_ERROR(20001, "失败"),
    //登录
    USER_ERROR(20100, "用户账号或者密码错误"),
    USERNAME_ERROR(20101, "用户账号不存在"),
    PASSWORD_ERROR(20102, "用户密码错误"),
    PRIORITY_ERROR(20103, "没有该权限"),
    USER_NOT_LOGGED(20104, "请登录");


    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
