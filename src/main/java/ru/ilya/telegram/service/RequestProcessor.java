package ru.ilya.telegram.service;

import ru.ilya.telegram.model.Update;
import ru.ilya.telegram.model.enums.RequestText;

public interface RequestProcessor {

    void process(Update update);
}
