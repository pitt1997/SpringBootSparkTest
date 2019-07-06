package com.cn.springboot04web.controller;

import com.cn.springboot04web.entities.Echarts;
import com.cn.springboot04web.entities.Result;
import com.cn.springboot04web.entities.Series;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SparkRDDCtroller {

    @GetMapping("/search")
    public String getAvgResult(Model model){
        //查询的事务逻辑
        //
        return "spark/search";
    }

    
    @RequestMapping(value = "/getSearchResult", method = RequestMethod.GET)
    @ResponseBody
    public Result<Echarts> doResult(Model model) {
        //构建Echarts对象，异步返回
        //图例
        List<String> legend = new ArrayList<String>(Arrays.asList(new String[] {"电影平均分"}));
        List<String> axis = new ArrayList<String>(
                Arrays.asList(new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R"}));
        Float []avgY=new Float[18];

        //纵坐标的值（每 个时间段对应的量）
        List<Series> series = new ArrayList<Series>();
        series.add(new Series("电影平均分","line",new ArrayList<Float>(Arrays.asList(avgY))));
        Echarts echarts = new Echarts(legend, axis, series);
        return Result.success(echarts);
    }

}
