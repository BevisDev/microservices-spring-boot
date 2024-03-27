package com.rest.enums;

import com.rest.dto.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    // =========================================================== //
    // ------------------ API Gateway Reject Code 4xx
    // =========================================================== //
    REJECT_METHOD_NOT_ALLOW("RJ1000", "Invalid Method."),
    REJECT_INVALID_MEDIA_TYPE("RJ1001", "Invalid Media Type."),
    REJECT_NOT_FOUND("RJ1002", "Not Found."),
    REJECT_INVALID_CREDENTIALS("RJ1003", "Security credentials is incorrect."),
    REJECT_NOT_AUTHORIZED_ACCESS("RJ1004", "User is not authorized to access this API."),
    REJECT_INVALID_API_KEY("RJ1005", "Invalid API Key."),

    // =========================================================== //
    // ------------------ API System Response Code
    // =========================================================== //
    // API Code 2xx -- Successful responses
    OK("S1000", "OK."),
    CREATED("S1001", "Created."),
    ACCEPTED("S1002", "Accepted."),
    NO_CONTENT("S1003", "No Content."),

    // API Code 3xx -- Direction
    NOT_MODIFIED("D1000", "Not Modified."),

    // API Code 4xx -- Client error
    INVALID_REQUEST("C1000", "Invalid Request."),
    INVALID_EMAIL("C1001", "Invalid Email."),

    // API Code 5xx - Server error
    SERVER_ERROR("A1000", "Internal Server Error."),
    SERVER_DOWN("A1001", "Server is down or under maintenance."),
    SERVER_TIMEOUT("A1002", "Server gateway is timed out"),
    ;

    private String statusCode;
    private String message;

    /**
     * set error code Internal Server Error.
     *
     * @param response extend BaseResponse
     * @param <T>      extend BaseResponse
     */
    public static <T extends BaseResponse> void setServerError(T response) {
        response.setResponseStatus(ResponseStatus.SERVER_ERROR);
        response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * set error code Invalid Request.
     *
     * @param response extend BaseResponse
     * @param <T>      extend BaseResponse
     */
    public static <T extends BaseResponse> void setInvalidRequest(T response) {
        response.setResponseStatus(ResponseStatus.INVALID_REQUEST);
        response.setHttpStatus(HttpStatus.BAD_REQUEST);
    }

}
