package com.cl.im.entity;

import com.cl.im.enums.ResEnums;
import lombok.Data;

@Data
public class R<T> {
    private Integer code;

    private String msg;

    private T data;

    public R(int code){
        this.code = code;
    }
    public R(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public R(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static  R succ(){
        return new R(ResEnums.SUCC.getCode(),ResEnums.SUCC.getMsg());
    }
    public static  R fail(){
        return new R(ResEnums.FAIL.getCode(),ResEnums.FAIL.getMsg());
    }
    public static <T> R<T> succ(T data){
        return new R<>(ResEnums.SUCC.getCode(),ResEnums.SUCC.getMsg(),data);
    }
    public static <T> R<T> fail(T data){
        return new R<>(ResEnums.FAIL.getCode(),ResEnums.FAIL.getMsg(),data);
    }
    public static <T> R<T> succ(String msg, T data){
        return new R<>(ResEnums.SUCC.getCode(),msg,data);
    }
    public static <T> R<T> fail(String msg, T data){
        return new R<>(ResEnums.FAIL.getCode(),msg,data);
    }

}
