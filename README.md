# G12306
12306火车票监控小工程

## 如何使用
> 运行环境

- jdk8
- idea运行代码
- maven 3.5.0

> 打包代码

- 在idea中运行maven命令：clean install；
- 包都放在lib目录下
- test.xls是文件记录模板，修改文件所在的路径即可(Constants.FILE_PATH)

> 打包代码

双击startup.bat即可运行程序。

## 功能
每间隔一分钟查询一次，查询到要求的火车票时，通过发送邮件进行提醒抢票，并记录在Excel文档中。

## 相关技术
- 用maven进行管理工程
- 定时任务用的Java自身的定时任务类
- 网络请求使用的是httpclient
- 请求之后解析json数据使用的是fastjson
- 使用lombok来生成get、set方法
- 用jxl来操作excel文档
- 用javax.mail-api发送简单的电子邮件

## 体会
1. 程序用来解决生活中的问题，才能激发出更好的编程兴趣，并且可以串联许多第三方组件，了解他们的用法；
2. 程序功能的实现都是站在开源组件之上，自己只是写了很少一部分，来实现自定义，完成自己的小小愿望；
3. 编程学习的技术和工具很多，并且更新比较快，掌握基本原则就是编程的核心，方能以不变应万变；
4. 适合自己才是最好。