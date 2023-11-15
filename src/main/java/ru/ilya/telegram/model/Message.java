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
public class Message implements TelegramBotApi{
    @JsonProperty("message_id")
    private Integer messageId;
    @JsonProperty("message_thread_id")
    private Integer messageThreadId;
    @JsonProperty("from")
    private User from;
    @JsonProperty("chat")
    private Chat chat;
}
