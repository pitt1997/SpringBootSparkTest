## spark+scala+springboot+echarts整合
## 开发工具 
IntelliJ IDEA 2017.3.1 x64
## 开发环境				

| JDK |Maven | Mysql |SpringBoot | scala |spark|
|--|--|--|--|--|--|
|1.8 | 3.2.2 | 5.5 | 1.5.9.RELEASE | 2.11.12 |2.3.0| 



## 使用说明

1. 下载代码 git clone https://github.com/pitt1997/    将项目下载到IDEA里面
2. 如果要运行sparkSQL程序，那么需要导入sql文件（运行sql文件夹下的sql文件，检查并
修改scala类AVGRatingOnGenreWithGender里面数据库连接的用户名与密码）
3. 到src/main/resources下的application.properties检查一些通用配置（端口、路径）
4. 访问地址：http://localhost:8081/crud/average 访问显示平均分（sparkSQL）
5. 访问地址：http://localhost:8081/crud/test 访问进行监听页面（sparkStreaming）
6. 上传文件，开启监听处理，并获取数据进行显示（打分文件在files文件夹里面，里面是按照
多个空格分隔，第一列是userId，第二列是movieId，第三列即分数，第四列为时间戳）
