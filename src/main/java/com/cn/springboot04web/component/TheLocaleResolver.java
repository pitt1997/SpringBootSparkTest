package com.cn.springboot04web.component;

import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class TheLocaleResolver implements LocaleResolver{
    Locale the_locale;
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        the_locale=Locale.getDefault();
        //System.out.println("2==!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+the_locale);
        if(StringUtils.isEmpty(l)){
            //System.out.println("2@==!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+the_locale);
            String[] split = l.split("_");
            new Locale(split[0],split[1]);
        }

        return the_locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}
