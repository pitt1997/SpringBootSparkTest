package com.cn.springboot04web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import java.util.Locale;



@SpringBootApplication
public class SpringBoot04WebRestfulCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04WebRestfulCrudApplication.class, args);
	}
	@Bean
	public ViewResolver myviewResolver(){
		return new MyViewResolver();
	}
	private static class MyViewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {

			

			return null;
		}
	}
}
