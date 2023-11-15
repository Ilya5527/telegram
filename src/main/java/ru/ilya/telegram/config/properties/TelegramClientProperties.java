package ru.ilya.telegram.config.properties;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "telegram-client")
public record TelegramClientProperties(@NotNull String token,
                                       @NotNull String url,
                                       @NotNull Integer retryLimit) {
}
