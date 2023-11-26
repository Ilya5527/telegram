package ru.ilya.telegram.config.properties;

import jakarta.annotation.Nonnull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "telegram-client")
public record TelegramClientProperties(@Nonnull String token,
                                       @Nonnull String url,
                                       @Nonnull Integer retryLimit,
                                       @Nonnull String webhookUrl) {
}
