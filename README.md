# QQ机器人

## 简介

- `bot-sdk` 实现 QQ 机器人 OpenAPI
- `bot-core` 实现机器人 WebSocket，以及机器人核心功能
- `bot-plugin-qwen` 实现通义千问插件

## 技术选型

1. Java 21
2. Spring Boot 3.2.0
3. Java-WebSocket 1.5.4

## 使用方式

1. 注册 [QQ 机器人](https://q.qq.com/#/)，获取 `AppID` 和 `Token`，添加环境变量 `BOT_APPID` 和 `BOT_TOKEN`
2. 注册[阿里云模型服务灵积](https://dashscope.aliyun.com/)，获取API-Key，添加环境变量 `DASHSCOPE_API_KEY`
3. 下载 `release` 中的安装包
4. 创建运行目录 `sudo mkdir -p /app`
5. 解压 `sudo tar xvf bot.tar.gz -C /app`
6. 启动 `sudo sh /app/bot/start.sh`

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