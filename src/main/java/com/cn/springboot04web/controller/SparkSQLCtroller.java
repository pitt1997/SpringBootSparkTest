package com.cn.springboot04web.controller;

import com.cn.springboot04web.entities.Echarts;
import com.cn.springboot04web.entities.MovieRating;
import com.cn.springboot04web.entities.Result;
import com.cn.springboot04web.entities.Series;
import com.cn.springboot04web.spark.sparksql.AVGRatingOnGenreWithGender;
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
import java.util.Iterator;
import java.util.List;

@Controller
public class SparkSQLCtroller {

    @GetMapping("/average")
    public String getAvgResult(Model model){
        //查询的事务逻辑
        //开启scala程序实现查询
        return "spark/average";
    }

    @GetMapping("/startDoAvg")
    @ResponseBody
    public Result<String> start(Model model){
        System.out.println("-------------------------------启动计算平均数程序-----------------------------");
        new AVGRatingOnGenreWithGender().getAvg();
        return Result.success("处理完成!!!");
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAvgResultWithGender", method = RequestMethod.GET)
    @ResponseBody
    public Result<Echarts> doResult(Model model) {


        //1.可以从数据库查询数据的逻辑

        //2.可以从文件里面读取数据的逻辑

        //3.可以从程序里面读取数据
        //MovieRating.FMap 可以取得18个种类电影男女平均分   （有些种类可能只有男性或女性）（还有无种类的情况）
       // int lengthFMap=MovieRating.FMap.size();
        //int lengthMMap=MovieRating.MMap.size();
        int typeLength=MovieRating.movieSet.size();
        //int max=Math.max(lengthFMap,lengthMMap);

        //System.out.println("max-"+max);
        //System.out.println("lengthFMap-"+lengthFMap);
        System.out.println("typeLength-"+typeLength);
        //1.构造axisArray，理解为横坐标种类？
        String []axisArray=new String[typeLength];
        //2.构造avgY_M男性数据
        Float []avgY_M=new Float[typeLength];
        //3.构造avgY_F女性数据
        Float []avgY_F=new Float[typeLength];
        Iterator<String> iterator = MovieRating.movieSet.iterator();
        int count=0;
        while(iterator.hasNext()){
            String tmp=iterator.next();
            System.out.println("-"+tmp);
            axisArray[count]=tmp;
            //男性
            if(MovieRating.MMap.containsKey(tmp)){
                avgY_M[count]=MovieRating.MMap.get(tmp);
            }else{
                //假设置初始值为0.0
                avgY_M[count]=0.0f;
            }
            //女性
            if(MovieRating.FMap.containsKey(tmp)){
                avgY_F[count]=MovieRating.FMap.get(tmp);
            }else{
                //假设置初始值为0.0
                avgY_F[count]=0.0f;
            }
            count++;
        }
        //图例
        List<String> legend = new ArrayList<String>(Arrays.asList(new String[] {"电影平均分-男","电影平均分-女"}));
        List<String> axis = new ArrayList<String>(
                Arrays.asList(axisArray));
        List<Series> series = new ArrayList<Series>();
        series.add(new Series("电影平均分-男","line",new ArrayList<Float>(Arrays.asList(avgY_M))));
        series.add(new Series("电影平均分-女","line",new ArrayList<Float>(Arrays.asList(avgY_F))));
        Echarts echarts = new Echarts(legend, axis, series);
        return Result.success(echarts);
    }

}
