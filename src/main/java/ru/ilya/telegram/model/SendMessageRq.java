package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendMessageRq implements TelegramBotApi{
    @JsonProperty("chat_id")
    private String chatId;
    @JsonProperty("message_thread_id")
    private Integer messageThreadId;
    @JsonProperty("text")
    private String text;
    @JsonProperty("parse_mode")
    private String parseMode;

}
