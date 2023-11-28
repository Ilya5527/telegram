package ru.ilya.telegram.model.enums;

import lombok.Getter;

@Getter
public enum RequestText {
    START("/start");

    private final String name;


    RequestText(String name) {
        this.name = name;
    }
}
