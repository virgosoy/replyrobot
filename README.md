# replyrobot
自动回复机器人

## 常用路径

### URL
后台管理页面: http://localhost/replyrobot/list

前台测试页面: http://localhost/replyrobot/talk

json接口测试页面： http://localhost/replyrobot/ajax

前台地图测试页面：http://localhost/replyrobot/map

### WebService
WebService 客户端Java代码所在路径：\replyrobot\src\test\java\com\soy\replyrobot\ws\client

## 功能概述
此工程为自动回复机器人，可以接受用户指令回复指定的内容。

回复的内容有2种：

* 从数据库查询出来，随机一条回复
* 执行方法，回复动态内容

对百度地图API进行了封装，可以方便的调用百度地图的web api。



