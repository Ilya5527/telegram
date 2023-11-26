package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SendMessageRequest(@JsonProperty("chat_id")
                                 String chatId,
                                 @JsonProperty("message_thread_id")
                                 Integer messageThreadId,
                                 @JsonProperty("text")
                                 String text) {

}
