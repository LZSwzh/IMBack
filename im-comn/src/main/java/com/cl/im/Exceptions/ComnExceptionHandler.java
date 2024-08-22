package com.cl.im.Exceptions;

import com.cl.im.Exceptions.BusinessException;
import com.cl.im.entity.R;
import com.cl.im.enums.ResEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 想要将异常也视作统一结果类，同时对异常进行集中的捕获，因此使用统一结果异常处理@ControllerAdvice
 */
@Slf4j
@Component//交给Spring管理
@RestControllerAdvice//Spring的组件，允许集中处理所有的异常，而不必在每个控制器方法中单独处理。
public class ComnExceptionHandler {
    /**
     * 只要Controller抛出EXception，就打印日志，并返回一个统一结果。
     * 这样一个异常也返回成一个统一结果了
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e){
      log.error(e.getMessage(),e);
      return R.fail();
    }
    /**
     * 上述的结果所有的异常都返回统一的响应：也就是ResEnum的Fail状态——服务器响应失败。
     * 如果想要针对特定的异常进行特定的处理，因此在这里对特定异常进行处理.
     * 比如自己的业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public R handleBusiExceptionHandler(BusinessException e){
        log.error(e.getMsg(),e);
        return R.fail(e.getMsg(),e.getCode());
    }

    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
             MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public R handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        //SERVLET_ERROR(-102, "servlet请求异常"),
        return R.fail(ResEnums.FAIL.getMsg(),ResEnums.FAIL.getCode());
    }
}
