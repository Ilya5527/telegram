package ru.ilya.telegram.client.telegram.api;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.ilya.telegram.config.TelegramFeignConfig;
import ru.ilya.telegram.model.GetUpdatesRequest;
import ru.ilya.telegram.model.Message;
import ru.ilya.telegram.model.SendMessageRequest;
import ru.ilya.telegram.model.SetWebhookRequest;
import ru.ilya.telegram.model.Update;

@FeignClient(url = "${telegram-client.url}", value = "telegram", configuration = TelegramFeignConfig.class)
public interface TelegramClientApi {

    @PostMapping(path = "/getUpdates", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<Update> getUpdates(@RequestBody GetUpdatesRequest request);

    @PostMapping(path = "/sendMessage", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Message sendMessage(@RequestBody SendMessageRequest request);

    @PostMapping(path = "/setWebhook", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Void setWebhook(@RequestBody SetWebhookRequest request);

    @PostMapping(path = "/deleteWebhook")
    Void deleteWebhook();

}
