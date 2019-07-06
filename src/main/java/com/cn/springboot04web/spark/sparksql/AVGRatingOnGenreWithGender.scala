package com.cn.springboot04web.spark.sparksql

import java.io.{File, PrintWriter}
import java.text.SimpleDateFormat
import java.util.Date

import com.cn.springboot04web.entities.MovieRating
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.stereotype.Component

import scala.collection.mutable.ArrayBuffer
@Component
class AVGRatingOnGenreWithGender {
  def getAvg(): Unit = {
    MyLogger.setLogLevelsToWARN()
    val sparkConf = new SparkConf().setAppName("AVGRatingOnGenreWithGender").setMaster("local[64]")
    val sc = new SparkContext(sparkConf)
    val spark = SparkSession.builder().getOrCreate()
    spark.sparkContext.setCheckpointDir("E:\\Beta\\Spark\\data\\checkpoint")

    println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
    var result = new ArrayBuffer[(String, String, Double)]()
    /*val genres = Array[String]("Action", "Adventure", "Animation", "Children",
      "Comedy", "Documentary", "Drama", "Fantasy",
      "Film-Noir", "Horror", "Musical", "Mystery",
      "Romance", "Sci-Fi", "Thriller", "War",
      "Western", "(no genres listed)")*/
    /* */
    val movies = spark.read.format("jdbc").option("url", "jdbc:mysql://localhost:3306/sparktest" +
      "?serverTimezone=Asia/Shanghai&user=root&password=123456" +
      "&characterEncoding=utf-8&useUnicode=true")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "movies").load().drop("title").repartition(64)

    val ratings = spark.read.format("jdbc").option("url", "jdbc:mysql://localhost:3306/sparktest" +
      "?serverTimezone=Asia/Shanghai&user=root&password=123456" +
      "&characterEncoding=utf-8&useUnicode=true")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "ratings").load().drop("timestamp").repartition(64)

    val users = spark.read.format("jdbc").option("url", "jdbc:mysql://localhost:3306/sparktest" +
      "?serverTimezone=Asia/Shanghai&user=root&password=123456" +
      "&characterEncoding=utf-8&useUnicode=true")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "users").load().drop("Zip-code").repartition(64)

    /*ratings.take(1)
    println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))*/
    val ratingOnGenreWithGender = movies.join(users.join(ratings, users("UserID") === ratings("userId")), "movieId").repartition(64)
    ratingOnGenreWithGender.cache()
    ratingOnGenreWithGender.checkpoint()

    val genres = movies.select("genres").collect().toList.flatMap(r => r(0).toString.split("\\|")).distinct

    //println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString)

    genres.foreach(v => {
      /*val tempDF = movies.join(users.join(ratings, users("UserID") === ratings("userId")), "movieId")
        .filter(row => row.getAs("genres").toString.contains(v))
        .groupBy("Gender").agg("rating" -> "avg")*/

      val tempList = ratingOnGenreWithGender.filter(ratingOnGenreWithGender("genres").contains(v))
        .groupBy("Gender").agg("rating" -> "avg").collectAsList()

      for(i <- 0 until tempList.size()){
        result += ((v, tempList.get(i).getString(0), tempList.get(i).getDouble(1)))
      }
    })

    println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
    result.foreach(println)
    //将数据存在hashmap里面
    result.foreach(
      v=>
        if(v._2.equals("F")){
          MovieRating.FMap.put(v._1,v._3.toFloat);
          //电影类型放入set里面
          MovieRating.movieSet.add(v._1)
          println(MovieRating.FMap.get(v._1))
        }else if(v._2.equals("M")){
          MovieRating.MMap.put(v._1,v._3.toFloat);
          //电影类型放入set里面
          MovieRating.movieSet.add(v._1)
          println(MovieRating.MMap.get(v._1))
        }
    )

    val writer = new PrintWriter(new File("E:\\Beta\\Spark\\data\\avgresult\\AVGRatingOnGenreWithGender.txt"))
    for(line <- result){
      writer.println(line.toString())
    }
    writer.close()
    //result
  }
}

object AVGRatingOnGenreWithGender {
  def main(args: Array[String]): Unit = {

    MyLogger.setLogLevelsToWARN()

    val sparkConf = new SparkConf().setAppName("AVGRatingOnGenreWithGender").setMaster("local[64]")
    val sc = new SparkContext(sparkConf)
    val spark = SparkSession.builder().getOrCreate()
    spark.sparkContext.setCheckpointDir("E:\\Beta\\Spark\\data\\checkpoint")

    println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
    var result = new ArrayBuffer[(String, String, Double)]()
    /*val genres = Array[String]("Action", "Adventure", "Animation", "Children",
      "Comedy", "Documentary", "Drama", "Fantasy",
      "Film-Noir", "Horror", "Musical", "Mystery",
      "Romance", "Sci-Fi", "Thriller", "War",
      "Western", "(no genres listed)")*/
                                                                            /* */
    val movies = spark.read.format("jdbc").option("url", "jdbc:mysql://localhost:3306/sparktest" +
      "?serverTimezone=Asia/Shanghai&user=root&password=123456" +
      "&characterEncoding=utf-8&useUnicode=true")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "movies").load().drop("title").repartition(64)

    val ratings = spark.read.format("jdbc").option("url", "jdbc:mysql://localhost:3306/sparktest" +
      "?serverTimezone=Asia/Shanghai&user=root&password=123456" +
      "&characterEncoding=utf-8&useUnicode=true")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "ratings").load().drop("timestamp").repartition(64)

    val users = spark.read.format("jdbc").option("url", "jdbc:mysql://localhost:3306/sparktest" +
      "?serverTimezone=Asia/Shanghai&user=root&password=123456" +
      "&characterEncoding=utf-8&useUnicode=true")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "users").load().drop("Zip-code").repartition(64)

    /*ratings.take(1)
    println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))*/
    val ratingOnGenreWithGender = movies.join(users.join(ratings, users("UserID") === ratings("userId")), "movieId").repartition(64)
    ratingOnGenreWithGender.cache()
    ratingOnGenreWithGender.checkpoint()

    val genres = movies.select("genres").collect().toList.flatMap(r => r(0).toString.split("\\|")).distinct

    //println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString)

    genres.foreach(v => {
      /*val tempDF = movies.join(users.join(ratings, users("UserID") === ratings("userId")), "movieId")
        .filter(row => row.getAs("genres").toString.contains(v))
        .groupBy("Gender").agg("rating" -> "avg")*/

      val tempList = ratingOnGenreWithGender.filter(ratingOnGenreWithGender("genres").contains(v))
          .groupBy("Gender").agg("rating" -> "avg").collectAsList()

      for(i <- 0 until tempList.size()){
        result += ((v, tempList.get(i).getString(0), tempList.get(i).getDouble(1)))
      }
    })

    println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
    result.foreach(println)

    val writer = new PrintWriter(new File("E:\\Beta\\Spark\\data\\avgresult\\AVGRatingOnGenreWithGender.txt"))
    for(line <- result){
      writer.println(line.toString())
    }
    writer.close()
  }
}
