package com.cn.springboot04web.spark

import java.io.PrintWriter
import java.net.ServerSocket

import scala.io.Source

object DataSourceSocket {
  def index(length: Int) = { //返回位于0到length-1之间的一个随机数
    val rdm = new java.util.Random
    rdm.nextInt(length)
  }
  def main(args: Array[String]) {
    //获取文件路径
    val fileName = "E:\\Beta\\Spark\\data\\test4_2\\word.txt"
    val lines = Source.fromFile(fileName).getLines.toList  //读取文件中的所有行的内容
    val rowCount = lines.length  //计算出文件的行数
    //创建监听特定端口的ServerSocket对象
    val listener = new ServerSocket(9999)
    println("启动服务器，监听端口：9999")
    while (true) {
      val socket = listener.accept()
      new Thread() {
        override def run = {
          println("获取客户端连接: " + socket.getInetAddress)
          val out = new PrintWriter(socket.getOutputStream(), true)
          while (true) {
            Thread.sleep("1000".toLong)  //每隔多长时间发送一次数据
            val content = lines(index(rowCount))  //从lines列表中取出一个元素
            println(content)
            out.write(content + '\n')  //写入要发送给客户端的数据
            out.flush()  //发送数据给客户端
          }
          socket.close()
        }
      }.start()
    }
  }
}
