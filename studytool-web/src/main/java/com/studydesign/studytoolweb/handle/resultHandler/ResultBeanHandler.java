package com.studydesign.studytoolweb.handle.resultHandler;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(annotations = RestController.class)
public class ResultBeanHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    @ResponseBody
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        try {
            if(body instanceof byte[]){
                return body;
            }
            Result result = ResultUtil.success(body);
            //兼容原来的接口返回
            if (body instanceof Result) {
                result = (Result) body;
            }
            //处理返回值是String的情况
            if (body instanceof String) {
                return JSON.toJSONString(result);
            }
            return result;
        }catch (Exception e){
            return  body;
        }

    }


}

