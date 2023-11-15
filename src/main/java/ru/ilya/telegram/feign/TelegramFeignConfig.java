package ru.ilya.telegram.feign;

import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import ru.ilya.telegram.exception.ExceptionConstants;
import ru.ilya.telegram.exception.ServiceUnavailableException;

public class TelegramFeignConfig extends BaseFeignConfiguration {
    private static final String TELEGRAM = "Telegram";

    @Value("${app.feign.telegram-client.retry}")
    private int retryCount;

    @Bean
    public ErrorDecoder telegramErrorDecoder() {
        return (methodKey, response) -> {

            if (response.status() >= 500) {
                return retry(response, new ServiceUnavailableException(String.format(ExceptionConstants.SERVICE_UNAVAILABLE, TELEGRAM)));
            }

            return new ServiceUnavailableException(String.format(ExceptionConstants.SERVICE_UNAVAILABLE, TELEGRAM));
        };
    }
}
