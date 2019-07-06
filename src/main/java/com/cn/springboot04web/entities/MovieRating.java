package com.cn.springboot04web.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MovieRating {
    public static HashMap<String,Float> map=new HashMap<String,Float>();
    public static ConcurrentMap<String, Float> tmpMap = new ConcurrentHashMap<String, Float>();
    //男性打分
    public static HashMap<String,Float> MMap=new HashMap<String,Float>();
    //女性打分
    public static HashMap<String,Float> FMap=new HashMap<String,Float>();
    //Set
    public static HashSet<String> movieSet=new HashSet<>();
    //所有分数
    public static ArrayList<Float> scoreList=new ArrayList<>();

    //初始化map值
    static {
        tmpMap.put("1",1.00f);
        tmpMap.put("2",2.01f);
        tmpMap.put("3",3.02f);
        tmpMap.put("4",4.02f);
        tmpMap.put("5",4.03f);
        tmpMap.put("6",4.04f);
        tmpMap.put("7",4.03f);
        tmpMap.put("8",4.03f);
        tmpMap.put("9",4.03f);
        tmpMap.put("10",3.03f);
        tmpMap.put("11",3.03f);
        tmpMap.put("12",4.04f);
        tmpMap.put("13",3.04f);
        tmpMap.put("14",4.03f);
        tmpMap.put("15",3.01f);
        tmpMap.put("16",4.02f);
        tmpMap.put("17",4.01f);
        tmpMap.put("18",3.02f);
    }

    //初始化map值
    static {
        map.put("1",3.00f);
        map.put("2",3.01f);
        map.put("3",3.02f);
        map.put("4",4.02f);
        map.put("5",4.03f);
        map.put("6",4.04f);
        map.put("7",4.03f);
        map.put("8",4.03f);
        map.put("9",4.03f);
        map.put("10",3.03f);
        map.put("11",3.03f);
        map.put("12",4.04f);
        map.put("13",3.04f);
        map.put("14",4.03f);
        map.put("15",3.01f);
        map.put("16",4.02f);
        map.put("17",4.01f);
        map.put("18",3.02f);
    }
    public MovieRating(){
    }
}
