package com.example.mssegipsimulation.component.response;

import org.springframework.http.HttpStatus;

public interface ErrorApiResponseServiceInterface {
    ApiResponse getObjectApiResponse(HttpStatus status, String message);
}
