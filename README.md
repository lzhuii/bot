# QQ机器人

## 简介

- `qq-bot-sdk` 实现 QQ 机器人 OpenAPI
- `qq-bot-core` 实现机器人 WebSocket，以及机器人核心功能
- `qq-bot-plugin-qwen` 实现通义千问插件

## 技术选型

1. Java 21
2. Spring Boot 3.2.0
3. Java-WebSocket 1.5.4

## 使用方式

1. 注册 [QQ 机器人](https://q.qq.com/#/)，获取 `AppID` 和 `Token`，添加环境变量 `BOT_APPID` 和 `BOT_TOKEN`
2. 注册[阿里云模型服务灵积](https://dashscope.aliyun.com/)，获取API-Key，添加环境变量 `DASHSCOPE_API_KEY`
3. 克隆项目到本地并导入 IDEA
4. `qq-bot-sdk` 执行 `mvn install` 将依赖安装到本地仓库
5. `qq-bot-core` 和 `qq-bot-plugin-qwen` 执行 `mvn package` 打包
6. 将编译产物按下面的目录结构部署
```bash
.
├── application.yml
├── qq-bot-core-0.0.1.jar
├── plugin/
│   └── qq-bot-plugin-qwen-0.0.1-jar-with-dependencies.jar
```

7. 启动机器人
```bash
java -Dloader.path=./plugin -jar ./qq-bot-core-1.0.0.jar
```

## SDK 已实现 QQ 频道 API 接口列表

- 获取通用 WSS 接入点
- 发送消息
    - 文字子频道


- 频道管理
    - 获取用户详情
    - 获取用户频道列表
    - 获取频道详情
    - 获取子频道列表
    - 获取子频道详情
    - 创建子频道
    - 修改子频道
    - 删除子频道


- 频道成员
    - 获取子频道在线成员数
    - 获取频道成员列表
    - 获取频道身份组成员列表
    - 获取频道成员详情
    - 删除频道成员


- 频道身份组与权限管理
    - 获取频道身份组列表


- 接口授权管理
    - 获取机器人在频道可用权限列表