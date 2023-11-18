package ru.ilya.telegram.client.telegram.api;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ilya.telegram.config.TelegramFeignConfig;
import ru.ilya.telegram.model.GetUpdatesRequest;
import ru.ilya.telegram.model.Message;
import ru.ilya.telegram.model.SendMessageRequest;
import ru.ilya.telegram.model.Update;

@FeignClient(url = "${telegram-client.url}", value = "telegram", configuration = TelegramFeignConfig.class)
public interface TelegramClientApi {

    @PostMapping(path = "/getUpdates", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<Update> getUpdates(GetUpdatesRequest getUpdatesRequest);

    @PostMapping(path = "/sendMessage", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Message sendMessage(SendMessageRequest sendMessageRequest);

}
