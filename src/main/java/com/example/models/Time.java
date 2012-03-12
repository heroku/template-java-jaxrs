package com.example.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.TimeZone;

@XmlRootElement
public class Time {

    private String timezone;
    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minute;
    private final int second;

    public Time() {
        this(TimeZone.getDefault());
    }

    public Time(TimeZone timezone) {
        final Calendar now = Calendar.getInstance(timezone);

        this.timezone = now.getTimeZone().getDisplayName();
        this.year = now.get(Calendar.YEAR);
        this.month = now.get(Calendar.MONTH) + 1;
        this.day = now.get(Calendar.DATE);
        this.hour = now.get(Calendar.HOUR);
        this.minute = now.get(Calendar.MINUTE);
        this.second = now.get(Calendar.SECOND);
    }

    public String getTimezone() {
        return timezone;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
