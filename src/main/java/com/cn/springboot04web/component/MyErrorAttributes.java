package com.cn.springboot04web.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
    //返回值的map就是页面和jaon能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","atguigu");
        //我们自己的异常处理器携带的数据
        Map<String,Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);//两个参数  第二个参数：从哪儿获取的 0是REQUESTSCOPE 1=SESSIONSCOPE 2=GLOBAL....
        map.put("ext",ext);
        return map;
    }
}
