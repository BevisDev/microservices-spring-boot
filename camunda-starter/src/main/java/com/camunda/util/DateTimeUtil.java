package com.camunda.util;

import com.camunda.enums.DateTimeEnum;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateTimeUtil {
    public static final int MILLIS_PER_SECOND = 1000;
    public static final int MILLIS_PER_MINUTE = 60 * 1000; // 1 minute
    public static final int MILLIS_PER_HOUR = 60 * 60 * 1000; // 1 hour
    public static final int MILLIS_PER_DAY = 24 * 60 * 60 * 1000; // 1 day

    // =========================================================== //
    // ------------------ Stored in the ISO 8601 format
    // =========================================================== //
    public static final String YYYY_MM_DD_T_HH_MM_SSZ = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss:SSSZ";
    public static final String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String MM_DD_YYYY = "MM/dd/yyyy";

    // =========================================================== //
    // ------------------ Date Time format
    // =========================================================== //
    public static final String DD_MMM_YYYY_HH_MM_SS = "dd-MMM-yyyy HH:mm:ss";
    public static final String DD_MMM_YYYY_DASH = "dd-MMM-yyyy";
    public static final String DD_MM_YY_SLASHED = "dd/MM/yy";
    public static final String MM_YYYY_SLASHED = "MM/yyyy";
    public static final String MMM_YYYY_SLASHED = "MMM/yyyy";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HH_MM = "HH:mm";


    /**
     * convert string to date
     *
     * @param str     input
     * @param pattern pattern of parse
     * @return date
     * @throws return new date()
     */
    public static Date convertToDate(String str, String pattern) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(str);
    }

    /**
     * convert date to string
     *
     * @param date    input
     * @param pattern pattern date
     * @return
     */
    public static String convertToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * get time at start of the day
     * 0:0:0:000
     *
     * @param date input
     * @return start of day
     */
    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 000);
        return calendar.getTime();
    }

    /**
     * get time in the end of day
     * 23:59:59:999
     *
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * get current time to end day
     *
     * @param endDate       end date
     * @param isGetEndOfDay get end of endDate 23:59:59:999
     * @return duration between current to end date
     */
    public static long timeLeftCurrentToEndDate(Date endDate, boolean isGetEndOfDay) {
        long currentTime = System.currentTimeMillis();
        long timeEndDate = endDate.getTime();
        if (isGetEndOfDay) {
            timeEndDate = getEndOfDay(endDate).getTime();
        }
        return timeEndDate - currentTime;
    }

    /**
     * to add date, month, year, week
     * and add hour, minute, second, millisecond
     *
     * @param date   date which want add
     * @param amount amount need to add
     * @return
     */
    public static Date add(DateTimeEnum type, Date date, int amount) {
        if (ValidateUtil.isNullOrEmpty(date)) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        switch (type) {
            case DATE:
                c.add(Calendar.DATE, amount);
                break;
            case MONTH:
                c.add(Calendar.MONTH, amount);
                break;
            case YEAR:
                c.add(Calendar.YEAR, amount);
                break;
            case WEEK:
                c.add(Calendar.WEEK_OF_YEAR, amount);
                break;
            case HOUR:
                c.add(Calendar.HOUR, amount);
                break;
            case MINUTE:
                c.add(Calendar.MINUTE, amount);
                break;
            case SECOND:
                c.add(Calendar.SECOND, amount);
                break;
            case MILLISECOND:
                c.add(Calendar.MILLISECOND, amount);
                break;
            default:
                log.error("type is not supported.");
                break;
        }
        return c.getTime();
    }

}
