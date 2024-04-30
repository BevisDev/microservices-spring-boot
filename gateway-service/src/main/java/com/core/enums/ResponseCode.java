package com.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    INVALID_REQUEST("A0001", "Invalid Request."),
    SERVER_ERROR("A0002", "Internal Server Error"),
    SERVER_DOWN("A0003", "Server is down or under maintenance"),
    SERVER_TIMEOUT("A0004", "Server gateway is timed out"),
    CORE_SERVICE_ERROR("A0005", "Error from Core Service"),
    NOTI_SERVICE_ERROR("A0006", "Error from Notification Service"),
    ;

    private String code;
    private String message;


}
