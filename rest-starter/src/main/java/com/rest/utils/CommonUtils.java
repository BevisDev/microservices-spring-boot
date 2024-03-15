package com.rest.utils;

import com.rest.constant.Const;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
public class CommonUtils {

    // =========== private String
    private static final List<String> alphabetList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    /**
     * init thread pool executor
     *
     * @param threadName       name of thread
     * @param corePoolSize     core pool
     * @param maxPoolSize      max pool
     * @param queueCapacity    queue size
     * @param keepAliveSeconds message is alive in seconds
     * @return init thread pool executor
     */
    public static ThreadPoolTaskExecutor initThreadPoolExecutor(String threadName, int corePoolSize, int maxPoolSize,
                                                                int queueCapacity, int keepAliveSeconds) {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setThreadNamePrefix(threadName + Const.DASH);
        pool.setCorePoolSize(corePoolSize);
        pool.setMaxPoolSize(maxPoolSize);
        pool.setQueueCapacity(queueCapacity);
        if (keepAliveSeconds > 0) {
            pool.setKeepAliveSeconds(keepAliveSeconds);
        }
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

    /**
     * capitalize first letter
     *
     * @param str input string entry
     * @return First letter is uppercase
     */
    public static String capitalizeFirstLetter(String str) {
        if (StringUtils.isEmpty(str)) return Const.EMPTY;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * sub on left string
     *
     * @param str      input
     * @param endIndex end index of string
     * @return new string start 0 to end index
     */
    public static String subOnLeft(String str, int endIndex) {
        if (StringUtils.isEmpty(str)) return Const.EMPTY;
        if (endIndex < 0 || endIndex >= str.length()) return str;
        return str.substring(0, endIndex);
    }

    /**
     * sub on right string
     *
     * @param str        input
     * @param beginIndex begin of index
     * @return new string start begin index to length input
     */
    public static String subOnRight(String str, int beginIndex) {
        if (StringUtils.isEmpty(str)) return Const.EMPTY;
        if (str.length() <= beginIndex) return str;
        return str.substring(str.length() - beginIndex);
    }

    /**
     * reverse string
     *
     * @param str input
     * @return new string is reversed
     */
    public static String reverse(String str) {
        if (StringUtils.isEmpty(str)) return Const.EMPTY;
        StringBuilder result = new StringBuilder(str);
        return result.reverse().toString();
    }

    /**
     * random UUID
     * eg 7df55507-9995-4c26-8ea7-0360c066b61e
     *
     * @return random UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * random text
     *
     * @param size length of text
     * @return new text
     */
    public static String randomText(int size) {
        if (size <= 0) return Const.EMPTY;

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int index = randomNumber(alphabetList.size());
            out.append(alphabetList.get(index));
        }
        return out.toString();
    }

    /**
     * random text numeric
     *
     * @param size length of text
     * @return new text numeric
     */
    public static String randomTextNumeric(int size) {
        if (size <= 0) return Const.EMPTY;

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < size; i++) {
            out.append(randomNumber(9));
        }
        return out.toString();
    }

    /**
     * random number range [1, size]
     *
     * @param size size of number
     * @return number
     */
    public static int randomNumber(int size) {
        if (size <= 0) {
            return 0;
        }
        Random random = new Random();
        return random.nextInt(size) + 1;
    }

    /**
     * format decimal
     *
     * @param input   big number
     * @param pattern pattern of format
     * @return new string after format
     */
    public static String formatDecimal(BigDecimal input, String pattern) {
        if (com.rest.utils.ValidateUtils.isNullOrEmpty(input)) {
            return Const.EMPTY;
        }
        if (StringUtils.isNotEmpty(pattern)) {
            try {
                DecimalFormat formatter = new DecimalFormat(pattern);
                return formatter.format(input);
            } catch (Exception ex) {
                log.error("formatDecimal has error: ", ex);
            }
        }
        return String.valueOf(input);
    }

}

