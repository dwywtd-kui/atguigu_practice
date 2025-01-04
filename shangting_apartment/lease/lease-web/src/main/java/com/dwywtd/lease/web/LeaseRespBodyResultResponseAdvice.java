package com.dwywtd.lease.web;

import com.dwywtd.lease.web.result.Result;
import com.dwywtd.lease.web.result.ResultBuild;
import com.dwywtd.lease.web.result.ResultCodeEnum;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RestControllerAdvice
public class LeaseRespBodyResultResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Class<?> typeDeclaringClass = returnType.getDeclaringClass();
        if (typeDeclaringClass.isAssignableFrom(Result.class)) {
            return false;
        }
        if (returnType.getMethodAnnotation(ResultBuild.class) != null) {
            return true;
        }
        return Objects.requireNonNull(returnType.getMethod()).getClass().getAnnotation(ResultBuild.class) != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return Result.ok(body);
    }


    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }
}
