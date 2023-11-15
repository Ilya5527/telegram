package ru.ilya.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Chat(@JsonProperty("id")
                   Integer id,
                   @JsonProperty("type")
                   String type,
                   @JsonProperty("title")
                   String title,
                   @JsonProperty("username")
                   String username,
                   @JsonProperty("first_name")
                   String firstName,
                   @JsonProperty("last_name")
                   String lastName,
                   @JsonProperty("is_forum")
                   Boolean isForum,
                   @JsonProperty("active_usernames")
                   List<String> activeUsername,
                   @JsonProperty("emoji_status_custom_emoji_id")
                   String emojiStatusCustomEmojiId,
                   @JsonProperty("emoji_status_expiration_date")
                   Integer emojiStatusExpirationDate,
                   @JsonProperty("bio")
                   String bio,
                   @JsonProperty("has__forwards")
                   Boolean hasPrivateForwards,
                   @JsonProperty("has_restricted_voice_and_video_messages")
                   Boolean hasRestrictedVoiceAndVideoMessage,
                   @JsonProperty("join_to_send_messages")
                   Boolean joinToSendMessage,
                   @JsonProperty("join_by_request")
                   Boolean joinByRequest,
                   @JsonProperty("description")
                   String description,
                   @JsonProperty("invite_link")
                   String inviteLink) {
}
