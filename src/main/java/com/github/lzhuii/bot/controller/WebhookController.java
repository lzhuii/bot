package com.github.lzhuii.bot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.lzhuii.bot.model.Payload;
import com.github.lzhuii.bot.service.WebhookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hui
 * @since 2024-12-28
 */
@Slf4j
@RestController
public class WebhookController {
    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping("/webhook")
    public Object webhook(@RequestBody Payload<JsonNode> payload) {
        log.info("收到Webhook请求 {}", payload);
        if (payload.getOp() == 13) {
            return webhookService.callbackVerify(payload);
        } else if (payload.getOp() == 0) {
            webhookService.dispatch(payload);
            log.info("收到用户消息");
            return "";
        } else {
            return "";
        }
    }
}
