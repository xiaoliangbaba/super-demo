package com.my.tool.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lilianga on 2018/11/30.
 */
public class DateUtil {
    // 获取上周一
    public static Date getLastWeekMonday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("上周一" + df.format(cal.getTime()));
        return cal.getTime();
        //return df.format(cal.getTime());
    }


    // 获取上周日
    public static String getLastWeekSunday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("上周日" + df.format(cal.getTime()));
        return df.format(cal.getTime());
    }


    // 获取上月第一天
    public static String getLastMonthDayOne(Date date) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("上月初：" + sdf.format(calendar1.getTime()));
        return sdf.format(calendar1.getTime());
    }


    // 获取上月最后一天
    public static String getLastMonthLastDay(Date date) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("上月末：" + sdf.format(calendar2.getTime()));
        return sdf.format(calendar2.getTime());
    }

    public static void main(String[] args) {

        Date date = new Date();
        Date date1 = getLastWeekMonday(date);
        System.out.println(date.getTime()>date1.getTime());
        getLastWeekMonday(date1);
        getLastWeekSunday(date);
    }


}
