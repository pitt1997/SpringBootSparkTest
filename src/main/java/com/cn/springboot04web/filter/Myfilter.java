package com.cn.springboot04web.filter;

import javax.servlet.*;
import java.io.IOException;

public class Myfilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    /*
    拦截器：
    开发人员可以实现用户在访问某个目标资源之前，对访问的请求和响应进行拦截
    --调用目标资源之前，让一段代码执行；
    --是否调用目标资源（即是否让用户访问web资源）;
    --调用目标资源之后，让一段代码执行。


     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process...拦截请求");

        //默认拦截："/" 代表所有请求；包括静态资源，但是不拦截jsp请求("/*"：会拦截jsp)
        //可以通过server.servletPath来修改springMVC前端控制器默认拦截的请求路径

        //做判断   if () true --调用dofilter   --false不调用！！！

        // 放行请求！！！
        chain.doFilter(request, response);
        /*
        web服务器在调用doFilter方法时，会传递一个filterChain对象进来，filterChain对象是filter接口中最重要的一个对象，
        它也提供了一个doFilter方法，开发人员可以根据需求决定是否调用此方法，调用该方法，则web服务器就会调用web资源的
        service方 法，即web资源就会被访问，否则web资源不会被访问。
         */
    }
    @Override
    public void destroy() {

    }
}
