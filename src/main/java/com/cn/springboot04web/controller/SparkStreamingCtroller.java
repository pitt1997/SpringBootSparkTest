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











    //暂时不用了
    @RequestMapping(value = "/getAvgResult02", method = RequestMethod.POST)
    @ResponseBody
    public Echarts getAvgResult02(HttpServletResponse response, String time){
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        //EcOrderCount ecOrderCounts=ecOrderStatisticsService.getCountsByTime(format1.parse(time));
        System.out.println("time------------------------------------------:"+time);
        //图例
        List<String> legend = new ArrayList<String>(Arrays.asList(new String[] { "全部订单","支付订单"}));
        //横坐标的值
        List<String> axis = new ArrayList<String>(
                Arrays.asList(new String[] {"1:00","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"}));
        Integer []l1={100,200,200,300,500,600,800,200,100,200,200,300,100,200,200,300,500,600,800,400,700,200,200,300};
        Integer []l2={100,500,200,800,500,600,800,900,100,700,200,300,100,200,200,300,500,500,800,200,100,200,900,300};
        //Action
        //{Action,Adventure,Animation,Children's,Comedy,Documentary,Drama,Fantasy,Film-Noir,Horror,Musical,Mystery,Romance,Sci-Fi,Thriller,War,Western,no genres listed}
        //纵坐标的值（每个时间段对应的量）
        List<Series> series = new ArrayList<Series>();
        series.add(new Series("全部订单","line",new ArrayList<Integer>(Arrays.asList(l1))));
        series.add(new Series("支付订单","line",new ArrayList<Integer>(Arrays.asList(l2))));
        Echarts echarts = new Echarts(legend, axis, series);
        return echarts;
    }

}
