package ru.ilya.telegram.service;

import ru.ilya.telegram.model.Update;

import java.util.List;

public interface TelegramService {

    List<Update> getUpdates();
}
