package com.cn.springboot04web.config;

import com.cn.springboot04web.filter.Myfilter;
import com.cn.springboot04web.listener.MyListener;
import com.cn.springboot04web.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration//@Configuration:作用：代表这是一个配置类
public class MyServerConfig {
    //注册3大组件！！
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return bean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Myfilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));//设置拦截URL的路径  Arrays.asList():转为集合
        return registrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
//        ServletListenerRegistrationBean registrationBean=new ServletListenerRegistrationBean();
//        registrationBean.setListener(new MyListener());

        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

    //配置嵌入式的Servlet容器
    @Bean  //加到容器中才可以起作用
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            //定制嵌入式的Servlet容器相关规则

            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                configurableEmbeddedServletContainer.setPort(8081);
            }
        };
    }
}
