package com.cn.springboot04web.spark.sparkstreaming

import com.cn.springboot04web.entities.MovieRating
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.springframework.stereotype.Component
@Component
class  KeepFileDirectory {
  def start() {
    StreamingExample.setStreamingLogLevels()
    //local[2]
    val conf = new SparkConf().setMaster("local").setAppName("NetWorkWordCount")
    //时间间隔：1s
    val ssc = new StreamingContext(conf, Seconds(3))
    //ssc.sparkContext.setLogLevel("ERROR")
    //指定输入流文件夹
    val lines = ssc.textFileStream("E:\\Beta\\Spark\\data\\final")

    val result = lines.filter(line=>(line.trim().length>0)&&line.split("\\s+").length==4)
      .map(row=>(row.split("\\s+")(1).toInt,row.split("\\s+")(2).trim().toFloat))
      .foreachRDD(rdd=>
      rdd.foreach {x=>
        println("到达result:"+x._1)
        MovieRating.movieIdList.add(x._1)
        MovieRating.scoreList.add(x._2)
        //MovieRating.movieIdList.add()
      }
    )

    val res = lines.filter(_.trim().length>0).map(line=>(line.split("\\s+")(1).trim().toInt,
      line.split("\\s+")(2).trim().toFloat)).groupByKey()
      .map(
        x => {
          var n = 0
          var sum = 0.0
          for (i <- x._2) {
            sum = sum + i
            n = n + 1
          }
          val avg = sum / n
          val format = f"$avg%1.2f".toDouble
          (x._1, format) //以（电影Id，平均分）格式输出至文件里面
        })
    res.print()
    println(res)
    res.foreachRDD{rdd =>
      rdd.foreach {
        v=>println(v)
          println("电影Id:"+v._1)
          println("电影平均分:"+v._2)
          MovieRating.map.put(v._1.toString,v._2.toFloat)
          MovieRating.tmpMap.put(v._1.toString,v._2.toFloat)
          println("map:"+MovieRating.map.get(v._1.toString))
          println("tmpMap:"+MovieRating.tmpMap.get(v._1.toString))
      }}
    //开始循环监听
    ssc.start()
    ssc.awaitTermination()
    //res
  }


  def startMonitor() {
    StreamingExample.setStreamingLogLevels()
    //local[2]
    val conf = new SparkConf().setMaster("local").setAppName("NetWorkWordCount")
    //时间间隔：1s
    val ssc = new StreamingContext(conf, Seconds(3))
    //ssc.sparkContext.setLogLevel("ERROR")
    //指定输入流文件夹
    val lines = ssc.textFileStream("E:\\Beta\\Spark\\data\\final")
    //println("lines.toString:"+lines.toString)
    //println("words:"+words)

    val result = lines.filter(line=>(line.trim().length>0)&&line.split("\\s+").length==4)
      .map(_.split("\\s+")(2))
      .foreachRDD(rdd =>
      rdd.foreach {x=>
        print("----------------------"+x.toFloat)
        MovieRating.scoreList.add(x.toFloat)
      }
    )

    val res = lines.filter(_.trim().length>0).map(line=>(line.split("\\s+")(1).trim().toInt,
      line.split("\\s+")(2).trim().toFloat)).groupByKey()
      .map(
        x => {
          var n = 0
          var sum = 0.0
          for (i <- x._2) {
            sum = sum + i
            n = n + 1
          }
          val avg = sum / n
          val format = f"$avg%1.2f".toDouble
          (x._1, format) //以（电影Id，平均分）格式输出至文件里面
        })



    res.print()
    println(res)
    res.foreachRDD{rdd =>
      rdd.foreach {
        v=>println(v)
          println("电影Id:"+v._1)
          println("电影平均分:"+v._2)
          MovieRating.map.put(v._1.toString,v._2.toFloat)
          MovieRating.tmpMap.put(v._1.toString,v._2.toFloat)
          println("map:"+MovieRating.map.get(v._1.toString))
          println("tmpMap:"+MovieRating.tmpMap.get(v._1.toString))
      }}
    //开始循环监听
    ssc.start()
    ssc.awaitTermination()
    //res
  }

}

object KeepFileDirectory {
  //val conf = new SparkConf().setMaster("local").setAppName("NetWorkWordCount")

  def main(args: Array[String]) {
    StreamingExample.setStreamingLogLevels()
                                      //local[2]
    val conf = new SparkConf().setMaster("local").setAppName("NetWorkWordCount")
    //时间间隔：1s
    val ssc = new StreamingContext(conf, Seconds(3))
    //ssc.sparkContext.setLogLevel("ERROR")
    //指定输入流文件夹
    val lines = ssc.textFileStream("E:\\Beta\\Spark\\data\\final")
    //println("lines.toString:"+lines.toString)
    //println("words:"+words)
    val res = lines.filter(_.trim().length>0).map(line=>(line.split("\\s+")(1).trim().toInt,
      line.split("\\s+")(2).trim().toFloat)).groupByKey()
      .map(
      x => {
        var n = 0
        var sum = 0.0
        for (i <- x._2) {
          sum = sum + i
          n = n + 1
        }
        val avg = sum / n
        val format = f"$avg%1.2f".toDouble
        (x._1, format) //以（电影Id，平均分）格式输出至文件里面
      })
    res.print()
    println(res)
    res.foreachRDD{rdd =>
      rdd.foreach {
        v=>println(v)
          println("电影Id:"+v._1)
          println("电影平均分:"+v._2)
          MovieRating.map.put(v._1.toString,v._2.toFloat)
          MovieRating.tmpMap.put(v._1.toString,v._2.toFloat)
          println("map:"+MovieRating.map.get(v._1.toString))
          println("tmpMap:"+MovieRating.tmpMap.get(v._1.toString))
      }}
    //开始循环监听
    ssc.start()
    ssc.awaitTermination()
  }


  def start() {
    StreamingExample.setStreamingLogLevels()
    //local[2]
    val conf = new SparkConf().setMaster("local").setAppName("NetWorkWordCount")
    //时间间隔：1s
    val ssc = new StreamingContext(conf, Seconds(3))
    //ssc.sparkContext.setLogLevel("ERROR")
    //指定输入流文件夹
    val lines = ssc.textFileStream("E:\\Beta\\Spark\\data\\final")
    //println("lines.toString:"+lines.toString)
    //println("words:"+words)
    val res = lines.filter(_.trim().length>0).map(line=>(line.split("\\s+")(1).trim().toInt,
      line.split("\\s+")(2).trim().toFloat)).groupByKey()
      .map(
        x => {
          var n = 0
          var sum = 0.0
          for (i <- x._2) {
            sum = sum + i
            n = n + 1
          }
          val avg = sum / n
          val format = f"$avg%1.2f".toDouble
          (x._1, format) //以（电影Id，平均分）格式输出至文件里面
        })
    res.print()
    println(res)
    res.foreachRDD{rdd =>
      rdd.foreach {
        v=>println(v)
          println("电影Id:"+v._1)
          println("电影平均分:"+v._2)
          MovieRating.map.put(v._1.toString,v._2.toFloat)
          MovieRating.tmpMap.put(v._1.toString,v._2.toFloat)
          println("map:"+MovieRating.map.get(v._1.toString))
          println("tmpMap:"+MovieRating.tmpMap.get(v._1.toString))
      }}
    //开始循环监听
    ssc.start()
    ssc.awaitTermination()
  }

}
