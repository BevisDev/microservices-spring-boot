package com.camunda.util;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class CommonUtil {

    /**
     * random UUID
     * eg 7df55507-9995-4c26-8ea7-0360c066b61e
     *
     * @return random UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

}

