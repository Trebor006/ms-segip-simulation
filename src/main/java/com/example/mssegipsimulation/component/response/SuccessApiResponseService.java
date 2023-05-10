package com.example.mssegipsimulation.component.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SuccessApiResponseService implements SuccessApiResponseServiceInterface {

    @Override
    public <T> ApiResponse createSuccessResponse(T data) {
        return ApiResponse.builder()
                .success(true)
                .data(data)
                .build();
    }
}
