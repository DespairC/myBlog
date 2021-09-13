package com.hwh.common.util;


import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具
 */
@Slf4j
public class TimeUtil {


    private static final Integer HOUR = 3600;

    private static final Integer MINUTE = 60;

    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String WEEK = "week";

    public static final List<String> TIME_LIST = Arrays.asList(
            DAY, WEEK, MONTH
    );

    /**
     * 格式： 2020-10-22 10:46:38
     * @return 时间字符串
     */
    public static String timeInitInString(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp.toString().substring(0,timestamp.toString().indexOf("."));
    }

    public static Timestamp timeInitInTimestamp(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        String time = timestamp.toString().substring(0,timestamp.toString().indexOf("."));
        return Timestamp.valueOf(time);
    }


    public static String getCurrentTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currentTime = dateFormat.format(date);
        return currentTime;
    }

    public static String longToDate(long time){
        Date date = new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return dateFormat.format(date);
    }

    public static String intToString(Integer time){
        if (VerifyUtil.isNull(time)){
            return null;
        }
        if (time > HOUR){
            return cutTime(String.valueOf(time * 1.0 / HOUR))+ "h";
        }else  if (time > MINUTE){
            return cutTime(String.valueOf(time * 1.0 / MINUTE)) + "m";
        }else{
            return time.toString() + "s";
        }
    }


    // 判断第一个时间是否在第二个时间之后
    public static boolean after(String first, String second){
        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        calendarStart.setTime(TimeUtil.stringToDate(first));
        calendarEnd.setTime(TimeUtil.stringToDate(second));
        return calendarStart.after(calendarEnd);
    }

    public static long dataToLong(String date){
        if (VerifyUtil.isNull(date)){
            return 0;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time.getTime();
    }

    /**
     * 保留到天
     * @param date
     * @return
     */
    public static long dataToLongKeepDay(String date){
        if (VerifyUtil.isNull(date)){
            return 0;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time.getTime();
    }

    public static Date stringToDate(String date){
        if (VerifyUtil.isEmpty(date)){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            log.info("时间转化时出现错误");
        }
        return null;
    }

    public static boolean isExpire(String expireTime){
        if (VerifyUtil.isEmpty(expireTime)){
            return false;
        }
        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        calendarStart.setTime(new Date());
        calendarEnd.setTime(TimeUtil.stringToDate(expireTime));
        return calendarStart.after(calendarEnd);
    }

    public static boolean isNearExpire(String expireTime){
        if (VerifyUtil.isEmpty(expireTime)){
            return false;
        }
        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        calendarStart.setTime(new Date());
        calendarEnd.setTime(TimeUtil.stringToDate(expireTime));
        calendarEnd.set(Calendar.DATE, calendarEnd.get(Calendar.DATE) - 5);
        if (calendarEnd.get(Calendar.DATE) != calendarStart.get(Calendar.DATE)){
            return false;
        }
        return calendarStart.after(calendarEnd);
    }

    public static boolean isMessageExpire(String time){
        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        calendarStart.setTime(TimeUtil.stringToDate(time));
        calendarEnd.setTime(new Date());
        calendarStart.set(Calendar.DATE, calendarStart.get(Calendar.DATE) + 1);
        return calendarStart.before(calendarEnd);
    }


    public static List<String> getTimeList(String startTime, String endTime){
        List<String> timeList = new ArrayList<>();

        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        // 设置起始时间和终止时间
        calendarEnd.setTime(TimeUtil.stringToDate(endTime));
        calendarStart.setTime(TimeUtil.stringToDate(startTime));

        long count = (calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis()) / (1000 * 3600 * 24) + 1;
        for (long i = 0; i < count; i++){
            timeList.add(getToday(dateToString(calendarEnd.getTime())));
            calendarEnd.set(Calendar.DATE, calendarEnd.get(Calendar.DATE) - 1);
        }
        return timeList;
    }

    public static String getToday(String time){
        return time.split(" ")[0];
    }


    public static String nextDay(String expireTime){
        if (VerifyUtil.isEmpty(expireTime)){
            return null;
        }
        Date expire = stringToDate(expireTime);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(expire);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return dateToString(calendar.getTime());
    }



    public static String cutTime(String time){
        if (VerifyUtil.isEmpty(time)){
            return null;
        }
        int pos = time.lastIndexOf(".");
        return time.substring(0,pos + 2);
    }

    public static String dateToString(Date time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(time);
    }

    public static String delTimeTail(String time){
        if(VerifyUtil.isEmpty(time)){
            return null;
        }
        try{
            time = time.substring(0, time.lastIndexOf("."));
        }catch (Exception e){
            return time;
        }
        return time;
    }

    public static String getTimeByType(String type) {
        Map condition=new HashMap();
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        switch (type) {
            case "2":
                calendar.set(Calendar.HOUR_OF_DAY,-24);
                break;
            case "3":
                calendar.set(Calendar.HOUR_OF_DAY,-168);
                break;
            case "4":
                calendar.set(Calendar.HOUR_OF_DAY,-720);
                break;
            default:
                break;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        condition.put("startTime",dateFormat.format(calendar.getTime()));
        return condition.get("startTime").toString();
    }

    public static String getDuration(String startTime, String endTime){
        if (VerifyUtil.isEmpty(startTime) || VerifyUtil.isEmpty(endTime)){
            return null;
        }
        Calendar calendarStart = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        calendarStart.setTime(stringToDate(startTime));
        calendarEnd.setTime(stringToDate(endTime));
        long second = (calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis()) / 1000;
        return secondToType(second);
    }

    private static String secondToType(long second){
        if (second < 60){
            return (second) + "秒";
        }else if (second > 60 && second < 3600){
            long minute = second / 60;
            return minute + "分" +  secondToType(second % 60);
        }else if (second > 3600 && second < 86400){
            long hour = second / 3600;
            return hour + "小时" + secondToType(second % 3600);
        }else {
            long day = second / 86400;
            return day + "天" + secondToType(second % 86400);
        }
    }


    public static String wxTimeToString(String timeEnd){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(timeEnd.substring(0,4)).append("-");
        stringBuilder.append(timeEnd.substring(4,6)).append("-");
        stringBuilder.append(timeEnd.substring(6,8)).append(" ");
        stringBuilder.append(timeEnd.substring(8,10)).append(":");
        stringBuilder.append(timeEnd.substring(10,12)).append(":");
        stringBuilder.append(timeEnd.substring(12,14));
        return stringBuilder.toString();
    }

    /**
     * 传入的时间与当前时间相差几天
     * @param time 传入的时间，晚于当前时间
     * @return 天数
     */
    public static long timeDifferCurrentDayToDay(String time){
        return (dataToLongKeepDay(time) - dataToLongKeepDay(getCurrentTime())) / 86400000;
    }

    /**
     * 传入的时间与当前时间相差多少小时
     * @param time 传入的时间，晚于当前时间
     * @return 小时数
     */
    public static long timeDifferCurrentDayToHour(String time){
        return (dataToLong(time) - dataToLong(getCurrentTime())) / 3600000;
    }


    public static void main(String[] args) {
        long l = dataToLongKeepDay("2020-10-01 11:00:55");
        long l2 = dataToLongKeepDay("2020-10-02 11:00:55");
        String s = longToDate(l);
        System.out.println(l);
        System.out.println(s);
        System.out.println((l2-l)/86400000 == 1);
    }
}
