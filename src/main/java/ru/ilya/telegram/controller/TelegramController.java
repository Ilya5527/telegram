package ru.ilya.telegram.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.ilya.telegram.model.SendMessageRequest;
import ru.ilya.telegram.model.Update;
import ru.ilya.telegram.service.TelegramService;

@RestController
@RequiredArgsConstructor
public class TelegramController {
    private final TelegramService telegramService;

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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> handleTelegramRequest(@RequestBody Update update, HttpServletRequest httpServletRequest) {
        telegramService.sendMessage(SendMessageRequest.builder()
                    .text("ПРИВЕТ ТЕСТ КАК ДЕЛА")
                    .chatId(update.message().chat().id().toString())
                .build());
        return ResponseEntity.ok().build();
    }
}
