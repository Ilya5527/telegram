package ru.ilya.telegram.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ilya.telegram.feign.TelegramFeignClient;
import ru.ilya.telegram.model.GetUpdatesRq;
import ru.ilya.telegram.model.Update;
import ru.ilya.telegram.service.TelegramService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramServiceImpl implements TelegramService {
    private final TelegramFeignClient telegramFeignClient;

    @Override
    public List<Update> getUpdates() {
        return telegramFeignClient.getUpdates(GetUpdatesRq.builder()
                .timeout(3)
                .build());
    }
}
