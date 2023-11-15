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
public class Update implements TelegramBotApi{
    @JsonProperty("update_id")
    private Integer updateId;
    private Message message;
}
