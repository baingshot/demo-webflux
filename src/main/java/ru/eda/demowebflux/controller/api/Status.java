package ru.eda.demowebflux.controller.api;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Nonnull;
import java.util.Objects;

public enum Status {

    SUCCESS("Success"),
    FAILED("Failed");

    private final String id;

    Status(@Nonnull String id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    @JsonValue
    public String getId() {
        return id;
    }

}
