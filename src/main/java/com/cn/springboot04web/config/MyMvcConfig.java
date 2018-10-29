package com.cn.springboot04web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//下面的配置类用自己的配置，即全面接管springmvc配置，所有配置要自己配（最初的springmvc配置）
//所有的springmvc的自动配置都失效
//@EnableWebMvc
//标注下面的类为配置类
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        //浏览器发送/atguigu请求来到success页面
        registry.addViewController("/atguigu").setViewName("success");//将什么请求(/atguigu)映射到什么页面(success)
        //registry.addViewController("/").setViewName("index");
        //registry.addViewController("/index.html").setViewName("index");
    }
    //所有的WebMvcConfigurerAdapter组件都会一起起作用   前提是spring boot应该知道这个组件的存在  @Bean
    @Bean  //作用：将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return adapter;
    }
}
