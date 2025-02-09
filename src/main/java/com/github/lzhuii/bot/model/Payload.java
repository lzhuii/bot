package com.github.lzhuii.bot.model;

import lombok.Data;

/**
 * 通用数据结构
 *
 * @author hui
 * @since 2025-01-04
 */
@Data
public class Payload<T> {
    /** 事件ID */
    private String id;
    /** 操作码，标识消息类型 */
    private Integer op;
    /** 事件内容 不同事件类型对应不同的数据结构 */
    private T d;
    /** 消息序列号 下行消息的唯一标识，客户端发送心跳时需携带最新的序列号 */
    private Integer s;
    /** 事件类型 仅在 op 为 0 (Dispatch) 时有效 */
    private String t;
}

