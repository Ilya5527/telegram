package ru.ilya.telegram.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppProperties {
    private Telegram telegramClient;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Telegram {
        private String url;
    }
}
