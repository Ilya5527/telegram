package ru.ilya.telegram.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.ilya.telegram.config.properties.TelegramClientProperties;

@Configuration
@EnableConfigurationProperties(TelegramClientProperties.class)
public class TelegramFeignConfig {

}
