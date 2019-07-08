package com.cn.springboot04web.controller;

import com.cn.springboot04web.entities.*;
import com.cn.springboot04web.spark.sparkstreaming.KeepFileDirectory;
import com.cn.springboot04web.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SparkStreamingCtroller {
    public static volatile int i=0;

    /**
     * 数据库里面查找平均分
     * @param model
     * @return
     */
    @GetMapping("/test")
    public String getAvgResult(Model model){
        //开启事务
        //new KeepFileDirectory().start();
        return "spark/score";
    }


    @GetMapping("/start")
    public Result<String> start(Model model){
        System.out.println("-------------------------------启动监听程序-----------------------------");
        new KeepFileDirectory().start();
        return Result.success("启动成功!!!");
    }


    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public Result<ResultLists> getList(Model model) {
        //返回一个数组
        System.out.println("---------------------------------到达getListMovieRating.scoreList--"+MovieRating.scoreList.size());
        System.out.println("---------------------------------到达getListMovieRating.movieIdList--"+MovieRating.movieIdList.size());
        ResultLists resultLists=new ResultLists();
        ArrayList <Integer>mlist=new ArrayList();
        ArrayList <Float>slist=new ArrayList();
        mlist.addAll(MovieRating.movieIdList);
        slist.addAll(MovieRating.scoreList);
        resultLists.movieIdList=mlist;
        resultLists.scoreList=slist;
        //清空list
        MovieRating.movieIdList.clear();
        MovieRating.scoreList.clear();
        System.out.println("---------------------------------操作.scoreList--"+MovieRating.scoreList.size());
        System.out.println("---------------------------------操作.movieIdList--"+MovieRating.movieIdList.size());
        System.out.println("---------------------------------操作.mlist--"+mlist.size());
        System.out.println("---------------------------------操作.slist--"+slist.size());
        return Result.success(resultLists);
    }

    @RequestMapping(value = "/getAvgResult", method = RequestMethod.GET)
    @ResponseBody
    public Result<Echarts> doResult(Model model) {
        //long result=getResult;
        i++;
        System.out.println(i+"--轮询次数 -----------------------------");
        //图例
        List<String> legend = new ArrayList<String>(Arrays.asList(new String[] {"电影平均分"}));
        List<String> axis = new ArrayList<String>(
                Arrays.asList(new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R"}));
        Float []avgY=new Float[18];
        int key=1;
        for(int i=0;i<18;i++){
            avgY[i]=MovieRating.tmpMap.get(key+"");
            System.out.println("tmpMap[i]:"+avgY[i]);
            System.out.println("map[i]:"+MovieRating.map.get(key+""));
            key++;
            System.out.println("key:"+key);
            System.out.println("avgY[i]:"+avgY[i]);
        }
        //纵坐标的值（每个时间段对应的量）
        List<Series> series = new ArrayList<Series>();
        series.add(new Series("电影平均分","line",new ArrayList<Float>(Arrays.asList(avgY))));
        Echarts echarts = new Echarts(legend, axis, series);
        return Result.success(echarts);
    }


    //处理文件上传
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    public  Result<String> uploadImg(@RequestParam("file")MultipartFile file,HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
        String filePath = "E:\\Beta\\Spark\\data\\final";
        //request.getSession().getServletContext().getRealPath("");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {

        }
        //返回json
        return Result.success("上传成功！");
    }



    @RequestMapping(value = "/getAvgResult03", method = RequestMethod.POST)
    @ResponseBody
    public Echarts getAvgResult03(HttpServletResponse response){
        //图例
        List<String> legend = new ArrayList<String>(Arrays.asList(new String[] {"电影平均分"}));
        List<String> axis = new ArrayList<String>(
                Arrays.asList(new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R"}));
        Float []avgY=new Float[18];
        int key=1;
        for(int i=0;i<18;i++){
            avgY[i]=MovieRating.map.get(key+"");
            key++;
            System.out.println("key:"+key);
            System.out.println("avgY[i]:"+avgY[i]);
        }
        //纵坐标的值（每个时间段对应的量）
        List<Series> series = new ArrayList<Series>();
        series.add(new Series("电影平均分","line",new ArrayList<Float>(Arrays.asList(avgY))));
        Echarts echarts = new Echarts(legend, axis, series);
        return echarts;
    }


}
