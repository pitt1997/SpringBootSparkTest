package com.cn.springboot04web.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//作用：作为登录页面的拦截器  实现HandlerInterCeptor接口
public class LoginHandlerInterceptor implements HandlerInterceptor{
    /*
    登录检查
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //在session里面取得loginUser值，如果有值的话那么代表该用户已经登录了
        Object user = request.getSession().getAttribute("loginUser");

        if(user==null){
            //未登录,不放行，使其回到登录首页，返回登录页面
            request.setAttribute("msg","没有权限，请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);//获取转发器,转发！！
            return false;
        }else{
            //已登录，放行请求
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
