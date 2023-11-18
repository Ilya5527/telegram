package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(@JsonProperty("id")
                   Integer id,
                   @JsonProperty("is_bot")
                   Boolean isBot,
                   @JsonProperty("first_name")
                   String firstName,
                   @JsonProperty("last_name")
                   String lastName,
                   @JsonProperty("username")
                   String userName,
                   @JsonProperty("language_code")
                   String languageCode,
                   @JsonProperty("is_premium")
                   Boolean isPremium,
                   @JsonProperty("added_to_attachment_menu")
                   Boolean addedToAttachmentMenu,
                   @JsonProperty("can_join_groups")
                   Boolean canJoinGroups,
                   @JsonProperty("can_read_all_group_messages")
                   Boolean canReadAllGroupMessage,
                   @JsonProperty("supports_inline_queries")
                   Boolean supportsInlineQueries) {

}
