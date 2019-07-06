package com.cn.springboot04web.spark.sparkstreaming

import org.apache.log4j.{Level, Logger}
import org.apache.spark.internal.Logging

object StreamingExample extends Logging{
  def setStreamingLogLevels(): Unit ={
    println("----------------------------------------------------------hhh")
    Logger.getRootLogger.setLevel(Level.ERROR)
    Logger.getRootLogger.setLevel(Level.WARN)
//    Logger.getLogger("org").setLevel(Level.ERROR)
//    Logger.getLogger("org.apache.spark.util.ClosureCleaner").setLevel(Level.ERROR)
//    Logger.getLogger("org.apache.spark.util.ClosureCleaner").setLevel(Level.ERROR)
//    Logger.getLogger("org.apache.spark.streaming.scheduler.JobScheduler").setLevel(Level.ERROR)
//    Logger.getLogger("org.apache.spark.ContextCleaner").setLevel(Level.ERROR)
//    Logger.getLogger("org.apache.spark.streaming.scheduler.JobScheduler").setLevel(Level.ERROR)
//    Logger.getLogger("org.apache.spark.streaming.scheduler.JobScheduler").setLevel(Level.ERROR)
//    Logger.getLogger("org.apache.spark.streaming.scheduler.JobScheduler").setLevel(Level.ERROR)


    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    val log4jInitial=Logger.getRootLogger.getAllAppenders.hasMoreElements
    if(!log4jInitial){
      logInfo("Setting log level to [WARN] for streaming example."+
      "To override add a custom log4j.properties to the classpath")
      Logger.getRootLogger.setLevel(Level.WARN)
      Logger.getLogger("org").setLevel(Level.ERROR)
    }
  }

}
