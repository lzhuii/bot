package com.github.lzhuii.bot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lzhuii.bot.api.QQBotApi;
import com.github.lzhuii.bot.model.Message;
import com.github.lzhuii.bot.model.Payload;
import com.github.lzhuii.bot.model.Verify;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author hui
 * @since 2025-01-15
 */
@Slf4j
@Service
public class WebhookService {
    private final ObjectMapper objectMapper;
    private final ChatModel chatModel;
    private final QQBotApi qqBotApi;
    @Value("${bot.app-secret}")
    private String appSecret;

    public WebhookService(ObjectMapper objectMapper, ChatModel chatModel, QQBotApi qqBotApi) {
        this.objectMapper = objectMapper;
        this.chatModel = chatModel;
        this.qqBotApi = qqBotApi;
    }

    @SneakyThrows
    public Verify.Request callbackVerify(Payload<JsonNode> payload) {
        // 获取必要的参数
        Verify verify = objectMapper.readValue(payload.getD().toString(), Verify.class);
        String plainToken = verify.getPlainToken();
        String eventTs = verify.getEventTs();
        // 构建用于生成种子字节的字符串
        StringBuilder seedBuilder = new StringBuilder(appSecret);
        while (seedBuilder.length() < 32) {
            seedBuilder.append(seedBuilder);
        }
        byte[] seedBytes = seedBuilder.substring(0, 32).getBytes(StandardCharsets.UTF_8);
        // 初始化私钥
        Ed25519PrivateKeyParameters privateKey = new Ed25519PrivateKeyParameters(seedBytes, 0);
        // 构建消息字符串并转换为字节数组
        String message = eventTs + plainToken;
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        // 初始化签名器并更新消息
        Ed25519Signer signer = new Ed25519Signer();
        signer.init(true, privateKey);
        signer.update(messageBytes, 0, messageBytes.length);
        // 生成签名并转换为十六进制格式的字符串
        byte[] signatureBytes = signer.generateSignature();
        String signature = Hex.toHexString(signatureBytes);
        log.info("生成签名: {}", signature);
        // 构建并返回验证响应
        Verify.Request request = Verify.Request.builder()
                .plainToken(plainToken)
                .signature(signature)
                .build();
        log.info("返回响应: {}", request);
        return request;
    }

    @SneakyThrows
    public void dispatch(Payload<JsonNode> payload) {
        Message message = objectMapper.readValue(payload.getD().toString(), Message.class);
        chatModel.stream(message.getContent())
                .flatMap(Mono::just)
                .collectList()
                .map(responseList -> String.join("", responseList))
                .flatMap(response -> {
                    log.info(response);
                    Message.Request request = Message.Request.builder()
                            .content(response)
                            .msgId(message.getId())
                            .build();
                    // 根据消息类型选择不同的消息发送方法
                    return switch (payload.getT()) {
                        case "C2C_MESSAGE_CREATE" -> qqBotApi.sendUserMsg(message.getAuthor().getId(), request);
                        case "GROUP_AT_MESSAGE_CREATE" -> qqBotApi.sendGroupMsg(message.getGroupOpenid(), request);
                        case "AT_MESSAGE_CREATE" -> qqBotApi.sendChannelMsg(message.getChannelId(), request);
                        case "DIRECT_MESSAGE_CREATE" -> qqBotApi.sendDirectMsg(message.getGuildId(), request);
                        case null, default -> Mono.empty();
                    };
                })
                .doOnNext(log::info)
                .subscribe();
    }
}
