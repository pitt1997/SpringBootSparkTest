package com.cn.springboot04web.component;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//实现点击连接 国际化
/*
可以在连接上携带区域信息
 */

//alt+enter  "重写方法快捷键"  自动补全操作
public class MyLocaleResolver implements LocaleResolver{
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {  //解析区域信息
        String l = httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(l)){//StringUtil作用：检查l值
            String[] split = l.split("_");
            locale=new Locale(split[0],split[1]);//第一个是语言代码  第二个是国家代码
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
