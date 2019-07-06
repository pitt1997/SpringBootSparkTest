package com.cn.springboot04web.spark

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._

object NetWorkWordCount {
  def main(args: Array[String]): Unit = { //nc -l -p 9999
    //StreamingExample.setStreamingLogLevels()
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetWorkWordCount")
    val ssc=new StreamingContext(conf,Seconds(1))
    //设置主机地址、通信端口号、部分在磁盘部分在硬盘
    val lines=ssc.socketTextStream("localhost",9999,StorageLevel.MEMORY_AND_DISK_SER)

    ssc.sparkContext.setLogLevel("ERROR")
    //ssc.sparkContext.set
    //获取所有单词 而flatMap与map唯一不一样的地方就是传入的函数在处理完后返回值必须是List
    val words=lines.flatMap(_.split(" "))
    //单词计数
    val wordCounts=words.map(x=>(x,1)).reduceByKey(_+_)
    wordCounts.print()
    //

    ssc.start()
    ssc.awaitTermination()
  }
}
