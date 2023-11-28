package ru.ilya.telegram.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ilya.telegram.model.SendMessageRequest;
import ru.ilya.telegram.model.Update;
import ru.ilya.telegram.model.enums.RequestText;
import ru.ilya.telegram.service.RequestProcessor;
import ru.ilya.telegram.service.TelegramService;
import ru.ilya.telegram.utility.MessageConstants;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TelegramController {
    private final TelegramService telegramService;
    private final Map<RequestText, RequestProcessor> requestProcessor;

    private static final String URL = "/handleTelegramRequest";

    @PostConstruct
    public void setWebhook() {
        telegramService.initializationTelegramBot(URL);
    }

    @PreDestroy
    public void deleteWebhook() {
        telegramService.shutdownTelegramBot();
    }

    @PostMapping(path = URL)
    public ResponseEntity<?> handleTelegramRequest(@RequestBody Update update) {
        preProcessRequest(update);
        return ResponseEntity.ok().build();
    }

    private void preProcessRequest (Update update) {
        try {
            RequestText requestText = RequestText.valueOf(update.message().text());
            requestProcessor.get(requestText).process(update);
        } catch (IllegalArgumentException ignored) {
            telegramService.sendMessage(SendMessageRequest.builder()
                            .text(MessageConstants.STUPID_BOT)
                            .chatId(update.message().chat().id().toString())
                    .build());
        }
    }
}
