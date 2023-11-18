package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetUpdatesRequest(@JsonProperty("offset")
                           Integer offset,
                                @JsonProperty("limit")
                           Integer limit,
                                @JsonProperty("timeout")
                           Integer timeout,
                                @JsonProperty("allowed_updates")
                           List<String> allowedUpdates) {
}
