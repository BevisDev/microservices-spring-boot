package com.bevis.identity.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    REJECT_INVALID_MEDIA_TYPE("RJ1001", "Invalid Media Type."),
    REJECT_INVALID_CREDENTIALS("RJ1003", "Security credentials is incorrect."),
    REJECT_NOT_AUTHORIZED_ACCESS("RJ1004", "User is not authorized to access this API."),
    REJECT_INVALID_API_KEY("RJ1005", "Invalid API Key."),

    SERVER_ERROR("I10001", "Server has error."),
    INVALID_REQUEST("I10002", "Invalid Request."),
    METHOD_NOT_ALLOW("I10003", "Invalid Method."),
    ;

    String errorCode;
    String message;
}
