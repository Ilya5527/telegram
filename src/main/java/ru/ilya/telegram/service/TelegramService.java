package ru.ilya.telegram.service;

import ru.ilya.telegram.model.Message;
import ru.ilya.telegram.model.SendMessageRequest;
import ru.ilya.telegram.model.Update;

import java.util.List;

public interface TelegramService {

    List<Update> getUpdates();

    void initializationTelegramBot(String url);

    void shutdownTelegramBot();

    Message sendMessage(SendMessageRequest request);
}
