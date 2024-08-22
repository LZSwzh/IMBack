package com.cl.im.judges;

import com.cl.im.Exceptions.BusinessException;
import com.cl.im.enums.ResEnums;
import lombok.extern.slf4j.Slf4j;

/**
 * 设置登录相关业务的自定义断言
 */
@Slf4j
public class LoginAssert {
    /**
     *断言对象不为空，obj 为空则抛异常
     * @param obj
     * @param resEnum
     */
    public static void notNull(Object obj,ResEnums resEnum){
        if (obj==null){
            log.info("obj is null..........");
            throw  new BusinessException(resEnum);
        }
    }
    /**
     *断言对象为空，obj 不为空则抛异常
     * @param obj
     * @param resEnum
     */
    public static void isNull(Object obj,ResEnums resEnum){
        if (obj==null){
            log.info("obj is not null..........");
            throw  new BusinessException(resEnum);
        }
    }
    /**
     *断言对象为真，obj 为假则抛异常
     * @param expr 条件
     * @param resEnum
     */
    public static void isTrue(Boolean expr,ResEnums resEnum){
        if (!expr){
            log.info("expr is not true..........");
            throw  new BusinessException(resEnum);
        }
    }
    /**
     *断言对象为真，obj 为假则抛异常
     * @param expr 条件
     * @param resEnum
     */
    public static void notTrue(Boolean expr,ResEnums resEnum){
        if (expr){
            log.info("expr is true..........");
            throw  new BusinessException(resEnum);
        }
    }
}
