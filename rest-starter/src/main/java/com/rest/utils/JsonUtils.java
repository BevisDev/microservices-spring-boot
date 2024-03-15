package com.rest.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class JsonUtils {

    /**
     * JSON to Class
     *
     * @param message JSON String
     * @param clazz   class
     * @param <T>     Object
     * @return return Object
     */
    public static <T> T parseJSON(String message, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // ignore unknown properties
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(message, clazz);
        } catch (Exception ex) {
            log.error("parseJSON has error: ", ex);
            return null;
        }
    }

    /**
     * JSON to class reference
     *
     * @param message  JSON string
     * @param clazzRef type refer
     * @param <T>      Object eg List, Map
     * @return Object
     */
    public static <T> T parseJSON(String message, TypeReference<T> clazzRef) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // ignore unknown properties
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(message, clazzRef);
        } catch (Exception ex) {
            log.error("parseJSON has error: ", ex);
            return null;
        }
    }

    /**
     * write Object to JSON String
     *
     * @param obj object
     * @return new string
     */
    public static String writeString(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception ex) {
            log.error("writeString has error: ", ex);
            return null;
        }
    }

    /**
     * compare JSON
     *
     * @param obj1 Object 1
     * @param obj2 Object 2
     * @return result of compare
     */
    public static boolean isEquals(Object obj1, Object obj2) {
        String ele1 = writeString(obj1);
        String ele2 = writeString(obj2);
        return StringUtils.equals(ele1, ele2);
    }

    /**
     * compare JSON equals ignore case
     *
     * @param obj1 Object 1
     * @param obj2 Object 2
     * @return result of compare
     */
    public static boolean isEqualsIgnoreCase(Object obj1, Object obj2) {
        String ele1 = writeString(obj1);
        String ele2 = writeString(obj2);
        return StringUtils.equalsIgnoreCase(ele1, ele2);
    }

}
