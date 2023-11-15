package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUpdatesRq implements TelegramBotApi{
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("timeout")
    private Integer timeout;
    @JsonProperty("allowed_updates")
    private List<String> allowedUpdates;
}
