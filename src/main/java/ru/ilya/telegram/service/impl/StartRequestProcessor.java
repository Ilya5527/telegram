package ru.ilya.telegram.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilya.telegram.model.SendMessageRequest;
import ru.ilya.telegram.model.Update;
import ru.ilya.telegram.service.RequestProcessor;
import ru.ilya.telegram.service.TelegramService;
import ru.ilya.telegram.utility.MessageConstants;

@Service("/start")
@RequiredArgsConstructor
public class StartRequestProcessor implements RequestProcessor {
    private final TelegramService telegramService;
    @Override
    public void process(Update update) {
        telegramService.sendMessage(SendMessageRequest.builder()
                        .text(MessageConstants.HELLO_MESSAGE)
                        .chatId(update.message().chat().id().toString())
                .build());
    }
}
