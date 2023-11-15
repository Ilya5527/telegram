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
public class User implements TelegramBotApi{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("is_bot")
    private Boolean isBot;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("language_code")
    private String languageCode;
    @JsonProperty("is_premium")
    private Boolean isPremium;
    @JsonProperty("added_to_attachment_menu")
    private Boolean addedToAttachmentMenu;
    @JsonProperty("can_join_groups")
    private Boolean canJoinGroups;
    @JsonProperty("can_read_all_group_messages")
    private Boolean canReadAllGroupMessage;
    @JsonProperty("supports_inline_queries")
    private Boolean supportsInlineQueries;
}
