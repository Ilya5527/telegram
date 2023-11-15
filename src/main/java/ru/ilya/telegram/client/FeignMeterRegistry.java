package ru.ilya.telegram.client;

import feign.FeignException;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeignMeterRegistry {

    private final MeterRegistry meterRegistry;

    private static final String DEFAULT_STATUS = "unknown";
    private static final String DEFAULT_EXCEPTION = "none";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private static final String STATUS_TAG = "status";
    private static final String EXCEPTION_TAG = "exception";
    private static final String RESULT_TAG = "result";
    private static final String URL_TAG = "url";

    public FeignMeterRegistry(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }


    public <R> R meter(Supplier<R> feignCaller, String timerName, String methodName) {
        final long startTime = System.nanoTime();

        String status = DEFAULT_STATUS;
        String exceptionName = DEFAULT_EXCEPTION;
        String result = FAIL;

        try {
            R response = feignCaller.get();
            result = SUCCESS;
            return response;
        } catch (FeignException exception) {
            status = String.valueOf(exception.status());
            exceptionName = exception.getClass().getSimpleName();
            throw exception;
        } catch (Exception exception) {
            exceptionName = Optional.ofNullable(exception.getCause())
                    .orElse(exception)
                    .getClass()
                    .getName();
            throw exception;
        } finally {
            meterTimeRecord(timerName, startTime, exceptionName, status, result, methodName);
        }
    }

    private void meterTimeRecord(String timerName,
                                 Long startTime,
                                 String exceptionName,
                                 String status,
                                 String result,
                                 String methodName) {
        try {
            meterRegistry.timer(
                    timerName,
                    Arrays.asList(
                            Tag.of(STATUS_TAG, status),
                            Tag.of(EXCEPTION_TAG, exceptionName),
                            Tag.of(RESULT_TAG, result),
                            Tag.of(URL_TAG, methodName)
                    )
            )
                    .record(System.nanoTime() - startTime, TimeUnit.SECONDS);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }

}
