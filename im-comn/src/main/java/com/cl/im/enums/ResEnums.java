package com.cl.im.enums;

import lombok.Data;


public enum ResEnums {
    FAIL("服务器响应失败",-1),
    SUCC("服务响应成功",1);

    private String msg;

    private int code;

    ResEnums(String msg,int code){
        this.msg = msg;
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

}
