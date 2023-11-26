package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record GetUpdatesRequest(@JsonProperty("offset")
                           Integer offset,
                                @JsonProperty("limit")
                           Integer limit,
                                @JsonProperty("timeout")
                           Integer timeout,
                                @JsonProperty("allowed_updates")
                           List<String> allowedUpdates) {
}
