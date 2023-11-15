package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record SendMessageRequest(@JsonProperty("chat_id")
                                 String chatId,
                                 @JsonProperty("message_thread_id")
                                 Integer messageThreadId,
                                 @JsonProperty("text")
                                 String text,
                                 @JsonProperty("parse_mode")
                                 String parseMode) {

}
