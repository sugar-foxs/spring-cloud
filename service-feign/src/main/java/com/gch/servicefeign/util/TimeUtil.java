package com.gch.servicefeign.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * @authod guchunhui
 * 2019-10-15 10:43
 **/
public class TimeUtil {


    public static String getZoneTimeFormatted(float timeZoneOffset) {
        return getZoneTimeFormatted(timeZoneOffset, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getZoneTimeFormatted(float timeZoneOffset,String format) {
        TimeZone timeZone = getTimeZone(timeZoneOffset);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

    public static long getZoneTime(float timeZoneOffset) {
        TimeZone timeZone = getTimeZone(timeZoneOffset);
        Calendar calendar = Calendar.getInstance(timeZone);
        return calendar.getTimeInMillis();
    }

    public static TimeZone getTimeZone(float timeZoneOffset) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }
        return timeZone;
    }

    public static void main(String[] args) {
        System.out.println(getZoneTime(10));
        System.out.println(getZoneTimeFormatted(10));
    }
}
