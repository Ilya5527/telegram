package ru.ilya.telegram.model;

import org.springframework.lang.NonNull;

public record SetWebhookRequest(@NonNull String url) {
}
