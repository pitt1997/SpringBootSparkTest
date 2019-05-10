package com.cn.springboot04web.controller;

import com.cn.springboot04web.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice  //成为异常处理器
public class MyExceptionHandler {

//    //应该解决浏览器与客户端都返回jaon数据的情况
//    @ResponseBody  //map以jaon的形式返回
//    @ExceptionHandler(UserNotExistException.class)//处理哪一个异常 Exception.calss就是处理所有异常
//    public Map<String, Object> handlerException(Exception e){//Exception e ：获取异常细腻些
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notexit");
//        map.put("message",e.getMessage()+"");
//        return map;
//    }
    //应该解决浏览器与客户端都返回jaon数据的情况
    //@ResponseBody  //map以jaon的形式返回
    @ExceptionHandler(UserNotExistException.class)//处理哪一个异常 Exception.calss就是处理所有异常
    public String handlerException(Exception e, HttpServletRequest request){//Exception e ：获取异常细腻些
    Map<String,Object> map=new HashMap<>();
    request.setAttribute("javax.servlet.error.status_code",500);
    map.put("code","user.notexit");
    map.put("message","用户异常！"+"----"+e.getMessage());
    request.setAttribute("ext",map);
    //转发到/error
    return "forward:/error";
    }

}
