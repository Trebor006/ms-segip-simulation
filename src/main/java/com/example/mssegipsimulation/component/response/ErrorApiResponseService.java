package com.example.mssegipsimulation.component.response;

import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorApiResponseService implements ErrorApiResponseServiceInterface {

    @Override
    public ApiResponse getObjectApiResponse(HttpStatus status, String message) {
        var error = ApiError.builder()
                .status(status)
                .message(message)
                .errors(Collections.singletonList(message))
                .build();

        return ApiResponse.builder()
                .success(false)
                .error(error)
                .build();
    }
}
