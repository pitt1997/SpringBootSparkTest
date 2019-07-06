package com.cn.springboot04web.spark.sparksql

import org.apache.log4j.{Level, Logger}
import org.apache.spark.internal.Logging

object MyLogger extends  Logging {
  def setLogLevelsToWARN(): Unit ={
    val log4jInitialized = Logger.getRootLogger.getAllAppenders.hasMoreElements
    if(!log4jInitialized){
      logInfo(("Setting log level to [WARN] for streaming example." +
        "To override add a custom log4j.properties to the classpath."))
      Logger.getRootLogger.setLevel((Level.WARN))
    }
  }
}
