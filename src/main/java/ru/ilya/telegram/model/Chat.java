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
public class Chat implements TelegramBotApi{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("username")
    private String username;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("is_forum")
    private Boolean isForum;
//    private ChatPhoto photo;
    @JsonProperty("active_usernames")
    private List<String> activeUsername;
    @JsonProperty("emoji_status_custom_emoji_id")
    private String emojiStatusCustomEmojiId;
    @JsonProperty("emoji_status_expiration_date")
    private Integer emojiStatusExpirationDate;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("has_private_forwards")
    private Boolean hasPrivateForwards;
    @JsonProperty("has_restricted_voice_and_video_messages")
    private Boolean hasRestrictedVoiceAndVideoMessage;
    @JsonProperty("join_to_send_messages")
    private Boolean joinToSendMessage;
    @JsonProperty("join_by_request")
    private Boolean joinByRequest;
    @JsonProperty("description")
    private String description;
    @JsonProperty("invite_link")
    private String inviteLink;
}
