package cn.blmdz.wapplet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blmdz.wapplet.base.Response;
import cn.blmdz.wapplet.enums.EnumsError;
import cn.blmdz.wapplet.exception.WAppletException;
import lombok.extern.slf4j.Slf4j;

/**
 * 最上级全局异常封装处理
 * @author xpoll
 */
@Slf4j
@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
    public Response<?> exceptionHandler(
    		Exception e) throws Exception {
        
        if (e instanceof WAppletException) {
            log.debug("WAppletException: {}", e.getMessage());
            if (((WAppletException) e).getEnumsError() == null) return Response.build(null).buildEnum(EnumsError.ERROR_999997).message(e.getMessage());
            else return Response.build(null).buildEnum(((WAppletException) e).getEnumsError());
        } else if (e instanceof MethodArgumentNotValidException) {
            
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            log.debug("MethodArgumentNotValidException: {}", ex.getBindingResult().getFieldError().getDefaultMessage());
            return Response.build(null).message(ex.getBindingResult().getFieldError().getDefaultMessage());
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            
            log.debug("HttpRequestMethodNotSupportedException: {}", e.getMessage());
            return Response.build(null).buildEnum(EnumsError.ERROR_000001);
        } else if (e instanceof MissingServletRequestParameterException) {
            
            log.debug("HttpRequestMethodNotSupportedException: {}", e.getMessage());
            return Response.build(null).buildEnum(EnumsError.ERROR_000002);
        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            
            log.debug("HttpMediaTypeNotSupportedException: {}", e.getMessage());
            return Response.build(null).buildEnum(EnumsError.ERROR_000003);
        }
        
        log.debug("Exception");
        e.printStackTrace();
        return Response.build(null).orNull(EnumsError.ERROR_999999);
    }
}
