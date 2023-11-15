package ru.ilya.telegram.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ilya.telegram.model.GetUpdatesRq;
import ru.ilya.telegram.model.Message;
import ru.ilya.telegram.model.SendMessageRq;
import ru.ilya.telegram.model.Update;

import java.util.List;

@FeignClient(url = "${app.feign.telegram-client.url}", value = "telegram", configuration = TelegramFeignConfig.class)
public interface TelegramFeignClient {
    @PostMapping(path = "/getUpdates", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<Update> getUpdates(GetUpdatesRq getUpdatesRq);

    @PostMapping(path = "/sendMessage", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Message sendMessage(SendMessageRq sendMessageRq);

}
