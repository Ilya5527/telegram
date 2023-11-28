package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Message(@JsonProperty("message_id")
                      Integer messageId,
                      @JsonProperty("message_thread_id")
                      Integer messageThreadId,
                      @JsonProperty("from")
                      User from,
                      @JsonProperty("chat")
                      Chat chat,
                      @JsonProperty("text")
                      String text) {
}
