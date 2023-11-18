package ru.ilya.telegram.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ilya.telegram.client.telegram.TelegramClientWrapper;
import ru.ilya.telegram.model.GetUpdatesRequest;
import ru.ilya.telegram.model.Update;
import ru.ilya.telegram.service.TelegramService;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramServiceImpl implements TelegramService {
    private final TelegramClientWrapper telegramFeignClient;

    @Override
    public List<Update> getUpdates() {
        GetUpdatesRequest getUpdatesRequest = new GetUpdatesRequest(null, null, 3, null);
        return telegramFeignClient.getUpdates(getUpdatesRequest);
    }

}
