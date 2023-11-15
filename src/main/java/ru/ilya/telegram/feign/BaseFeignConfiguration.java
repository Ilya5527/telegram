package ru.ilya.telegram.feign;

import feign.RequestInterceptor;
import feign.Response;
import feign.RetryableException;
import org.springframework.context.annotation.Bean;

public class BaseFeignConfiguration {

    public Exception retry(Response response, Throwable cause) {
        return new RetryableException(
                response.status(),
                cause.getMessage(),
                response.request().httpMethod(),
                cause,
                null,
                response.request());
    }
}
