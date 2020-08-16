package ru.eda.demowebflux.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

public class Response<T> {
    @Nonnull
    private final Status status;
    @Nullable
    private final T result;
    @Nullable
    private final String error;

    private Response(Status status, T result, String error) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.error = error;
    }

    @JsonGetter("status")
    public Status getStatus() {
        return status;
    }

    @JsonGetter("result")
    public Optional<T> getResult() {
        return Optional.ofNullable(result);
    }

    @JsonGetter("error")
    public Optional<String> getError() {
        return Optional.ofNullable(error);
    }

    public static <T> Response<T> success(T result) {
        return new Builder().status(Status.SUCCESS)
                .build(result);
    }

    public static <T> Response<T> failed(String error) {
        return new Builder().status(Status.FAILED)
                .error(error)
                .build();
    }

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> failed() {
        return failed(null);
    }

    public static Builder status(Status status) {
        return new Builder().status(status);
    }

    public static class Builder {
        private Status status;
        private String error;

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public <T> Response<T> build(T result) {
            return new Response<>(
                    status,
                    result,
                    error);
        }

        public <T> Response<T> build() {
            return build(null);
        }
    }
}
