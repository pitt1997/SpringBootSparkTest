package com.cn.springboot04web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //@PostMapping//相当于下面的作用   处理POSTs
    @RequestMapping(value = "user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password
                        , Map<String,Object> map, HttpSession session){
        System.out.println("1----------------------------------------------------------------");
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            //登录成功往session里面添加用户！！！session里面如果有则代表已经登录  作为标记！！！
            System.out.println("2----------------------------------------------------------------");
            //登录成功          防止表单重复提交可以使用重定向的主页
            return "redirect:/main.html";            //由于main.html页面添加了视图映射，直接到dashboard视图

        }else {
            map.put("msg","用户名或密码错误！");
            return "login";
        }
    }
}
