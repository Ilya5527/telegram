package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Update(@JsonProperty("update_id")
                     Integer updateId,
                     @JsonProperty("message")
                     Message message) {
}
