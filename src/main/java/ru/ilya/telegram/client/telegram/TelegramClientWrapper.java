package ru.ilya.telegram.client.telegram;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.ilya.telegram.client.FeignMeterRegistry;
import ru.ilya.telegram.client.telegram.api.TelegramClientApi;
import ru.ilya.telegram.model.GetUpdatesRequest;
import ru.ilya.telegram.model.Message;
import ru.ilya.telegram.model.SendMessageRequest;
import ru.ilya.telegram.model.Update;

@Slf4j
@Component
public class TelegramClientWrapper {

    private final TelegramClientApi client;
    private final FeignMeterRegistry feignMeterRegistry;

    private static final String CLIENT_TIMER_NAME = "TelegramClientTimer";

    public TelegramClientWrapper(TelegramClientApi client, FeignMeterRegistry feignMeterRegistry) {
        this.client = client;
        this.feignMeterRegistry = feignMeterRegistry;
    }

    public List<Update> getUpdates(GetUpdatesRequest getUpdatesRequest) {
        return feignMeterRegistry.meter(
                () -> client.getUpdates(getUpdatesRequest),
                CLIENT_TIMER_NAME,
                "getUpdates"
        );
    }

    public Message sendMessage(SendMessageRequest sendMessageRequest) {
        return feignMeterRegistry.meter(
                () -> client.sendMessage(sendMessageRequest),
                CLIENT_TIMER_NAME,
                "sendMessage"
        );
    }

}
