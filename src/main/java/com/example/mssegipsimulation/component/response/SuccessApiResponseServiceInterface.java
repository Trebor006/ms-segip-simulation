package com.example.mssegipsimulation.component.response;

public interface SuccessApiResponseServiceInterface {
    <T> ApiResponse createSuccessResponse(T data);
}
