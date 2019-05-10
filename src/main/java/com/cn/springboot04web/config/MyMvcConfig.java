package com.cn.springboot04web.config;

import com.cn.springboot04web.component.LoginHandlerInterceptor;
import com.cn.springboot04web.component.MyLocaleResolver;
import com.cn.springboot04web.component.TheLocaleResolver;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

//下面的配置类用自己的配置，即全面接管springmvc配置，所有配置要自己配（最初的springmvc配置）
//所有的springmvc的自动配置都失效
//@EnableWebMvc
//标注下面的类为配置类
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
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
                //添加视图映射,setViewName("");设置视图名
                registry.addViewController("/main.html").setViewName("dashboard");
            }


            //ctrl+o  重写快捷
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //springboot已经做好了静态资源的映射了，所以不用管*.js,*.css等等,他们能够正常访问
    //            registry.addInterceptor(new LoginHandlerInterceptor())
    //                    .addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
