package com.cl.im.Exceptions;

import com.cl.im.enums.ResEnums;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    /**
     * 八股复习——异常的分类：
     *   Throwable:
     *      - Exception:
     *          - RuntimeException：运行时异常，通常是程序设计失误，无需手动捕获。常见异常如下
     *                  - 索引越界异常、类转换异常、空指针异常、算数异常、并发修改等
     *          - 编译期异常：除了运行时异常基本都算(IO、ClassNotFound...)，需要手动捕获
     *      - Error：很少见到，虚拟机抛出，无需手动管理
     */

    //状态码
    private Integer code;

    //错误信息
    private String msg;

    /**
     * @param msg 错误信息
     */
    public BusinessException(String msg){
        this.msg = msg;
    }

    /**
     * @param code 错误码
     * @param msg 错误信息
     */
    public BusinessException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * @param code 错误码
     * @param msg 错误信息
     * @param cause 原始异常
     */
    public BusinessException(Integer code,String msg,Throwable cause){
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     */
    public BusinessException(ResEnums resultCodeEnum) {
        this.msg = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
    }

    /**
     * @param resultCodeEnum 接收枚举类型
     * @param cause 原始异常对象
     */
    public BusinessException(ResEnums resultCodeEnum, Throwable cause) {
        super(cause);
        this.msg = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
    }
}
