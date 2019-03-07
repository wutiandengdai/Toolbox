package com.github.toolbox.java_utils.datetime;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * DateTool 封装了一些日期常用方法
 * @author Xjw
 * @version 1.0
 */
public class DateUtils{

    public final static short DATE_YEAR = 0;
    public final static short DATE_MONTH = 1;
    public final static short DATE_DAY = 2;
    public final static short DATE_HOUR = 3;
    public final static short DATE_MINUTE = 4;
    public final static short DATE_SECOND = 5;

   public static  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将date转为calendar
     * @param date 指定日期
     * @return
     */
    public static Calendar dateToCalerdar(Date date) throws Exception{
        try{
            if(date == null){
                return null;
            }
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.setTime(date);
            return cal;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取指定年月日的calendar
     * @param year 指定年
     * @param month 指定月（0-11）
     * @param date 指定日
     * @return
     */
    public static Date getDate(int year, int month, int date) throws Exception{
        try {
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.set(year, month, date);
            return cal.getTime();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取指定年月日时分的calendar
     * @param year 指定年
     * @param month 指定月（0-11）
     * @param date 指定日
     * @param hourOfDay 指定时(24小时制)
     * @param minute 指定分
     * @return
     * @throws Exception
     */
    public static Date getDate(int year, int month, int date, int hourOfDay, int minute) throws Exception{
        try {
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.set(year, month, date, hourOfDay, minute);
            return cal.getTime();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取指定年月日时分秒的calendar
     * @param year 指定年
     * @param month 指定月（0-11）
     * @param date 指定日
     * @param hourOfDay 指定时(24小时制)
     * @param minute 指定分
     * @param second 指定秒
     * @return
     * @throws Exception
     */
    public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second) throws Exception{
        try {
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.set(year, month, date, hourOfDay, minute, second);
            return cal.getTime();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 将日期转为一定格式的字符串
     * @param date 日期
     * @param format 日期格式字符串
     * @return 转换后的日期字符串
     * @throws Exception
     */
    public static String dateToString(Date date, String format) throws Exception{
        try {
            SimpleDateFormat sdf ;
            if(date == null){
                return null;
            }
            if(format==null){
                sdf =sdf1;
            }else {
                sdf =  new SimpleDateFormat(format);
            }
            return sdf.format(date);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 将日期转为一定格式的字符串
     * @param datetime 时间戳
     * @param format 日期格式字符串
     * @return 转换后的日期字符串
     * @throws Exception
     */
    public static String dateToString(long datetime, String format) throws Exception{
        try {
            if (datetime == 0){
                return "";
            }
            Date d = new Date(datetime);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(d);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 根据传入的格式和值获得Date型
     * @param value 传入日期字符串
     * @param format 格式字符串
     * @return 日期
     */
    public static Date strToDate(String value, String format) throws Exception{
        try {
            if(value == null || "".equals(value.trim())){
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(value);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获得指定日期当天的最小值（例如 1990-10-30 00:00:01）
     * @param date 指定日期
     * @return
     * @throws Exception
     */
    public static Date getTodayMin(Date date) throws Exception{
        try {
            if(date == null){
                return null;
            }
            GregorianCalendar gc = getGregorianCalendar(date, 0, 0, 0);
            return gc.getTime();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获得指定日期当天的最大值（例如 1990-10-30 23:59:59）
     * @param date 指定日期
     * @return
     * @throws Exception
     */
    public static Date getTodayMax(Date date) throws Exception{
        try {
            if(date == null){
                return null;
            }
            GregorianCalendar gc = getGregorianCalendar(date, 23, 59, 59);
            return gc.getTime();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 根据小时，分，秒，获取GregorianCalendar
     * 返回年月日=当前年月日 + 天数(正数)
     *
     * @param date
     * @param hourOfDay
     * @param minute
     * @param second
     * @param
     * @return
     * @throws ParseException
     */
    private static GregorianCalendar getGregorianCalendar(Date date, int hourOfDay, int minute, int second) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(GregorianCalendar.HOUR_OF_DAY, hourOfDay);
        gc.set(GregorianCalendar.MINUTE, minute);
        gc.set(GregorianCalendar.SECOND, second);
        return gc;
    }
    public static String getAddDay(Date date, int sub, String format) throws ParseException {
        DateFormat sf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, sub);
        return sf.format(calendar.getTime());
    }

    /**
     * 指定日期加减日期
     * @param date 指定日期
     * @param value 要加减的数值，负数为减
     * @param type 类型,(数值不正确时默认为加减天数)
     * 返回年月日=当前年月日(yyyyMMdd) + 天数(正数)
     *
     * @param
     * @param
     * @return
     * @throws Exception
     * @throws ParseException
     */
    public static Date addDay(Date date, int value, short type) throws Exception {
        try {
            if (date == null) {
                return null;
            }
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.setTime(date);
            switch (type) {
                case DateUtils.DATE_YEAR: {
                    cal.add(Calendar.YEAR, value);
                    break;
                }
                case DateUtils.DATE_MONTH: {
                    cal.add(Calendar.MONTH, value);
                    break;
                }
                case DateUtils.DATE_DAY: {
                    cal.add(Calendar.DAY_OF_MONTH, value);
                    break;
                }
                case DateUtils.DATE_HOUR: {
                    cal.add(Calendar.HOUR_OF_DAY, value);
                    break;
                }
                case DateUtils.DATE_MINUTE: {
                    cal.add(Calendar.MINUTE, value);
                    break;
                }
                case DateUtils.DATE_SECOND: {
                    cal.add(Calendar.SECOND, value);
                    break;
                }
                default: {
                    cal.add(Calendar.DAY_OF_MONTH, value);
                    break;
                }
            }
            return cal.getTime();
        } catch (Exception e) {
            throw e;
        }
    }
    public static String getAddDay(String day, int sub, String format) throws ParseException {
        DateFormat sf = new SimpleDateFormat(format);
        Calendar c = getCalendarInstance(day, format);
        c.add(Calendar.DAY_OF_MONTH, sub);
        return sf.format(c.getTime());
    }


    /**
     * 获得指定日期的年月日时分秒,用数组形式int[]
     * @param date 指定日期
     * @return
     * 获得日历对象
     * @return Calendar
     * @throws Exception
     * @throws ParseException
     */
    public static int[] returnIntArray(Date date) throws Exception{
        try{
            if(date == null){
                return null;
            }
            Calendar cal = Calendar.getInstance();
            cal.clear();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
            return new int[] { year, month, day, hour, minute, second};
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 比较两个日期
     * @param date1	指定日期1
     * @param date2  指定日期2
     * @return	date1等于date2，则返回 0 值；date1在date2之前，
     * 则返回小于 0 的值；date1在date2之后，则返回大于 0 的值。
     * @throws Exception
     */
    public static int compareTo(Date date1, Date date2) throws Exception{
        try {
            if(date1 == null || date2 == null){
                throw new IllegalArgumentException("date1和date2不能为空");
            }
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.setTime(date1);
            Calendar cal2 = new GregorianCalendar();
            cal2.clear();
            cal2.setTime(date2);
            return cal.compareTo(cal2);
        }catch (Exception e) {
            throw e;
        }
    }

    /**
     * 判断两个日期是否为同一天
     * @param date1	日期1
     * @param date2	日期2
     * @return boolean true相同，false 不同,当有参数为null时，返回false
     */
    public static boolean isSameDay(Date date1, Date date2) throws Exception{
        try {
            if(date1 == null || date2 == null){
                return false;
            }
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.setTime(date1);
            int[] date1Val = {cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)};
            cal.clear();
            cal.setTime(date2);
            int[] date2Val = {cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)};
            return date1Val[0] == date2Val[0] && date1Val[1] == date2Val[1] && date1Val[2] == date2Val[2];
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * 去除指定日期的时分秒
     * @param date 日期
     * @return 时分秒都为0的日期
     * @throws Exception
     */
    public static Date removeHMS(Date date) throws Exception{
        try {
            if(date == null){
                return null;
            }
            Calendar cal = new GregorianCalendar();
            cal.clear();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND,0);
            return cal.getTime();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获得指定日期的当前周，上一周或下一周的指定星期几的日期
     * @author xjw
     * @param date	指定日期
     * @param weekDay	星期几
     * @param type	0：当前周，-1：上一周，1：下一周
     * @return 日期DateTool.getTodayMax(DateTool.getWeekDay(new Date(), Calendar.SUNDAY, (short) 1))
     */
    public static Date getWeekDay(Date date, int weekDay, short type) {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.clear();
        cal.setTimeInMillis(date.getTime());
        cal.set(Calendar.DAY_OF_WEEK, weekDay);
        if (type == -1) {
            cal.setTimeInMillis(cal.getTimeInMillis() - (7 * 3600 * 24 * 1000));
        } else if (type == 1) {
            cal.setTimeInMillis(cal.getTimeInMillis() + (7 * 3600 * 24 * 1000));
        }
        return cal.getTime();
    }
    public static Calendar getCalendarInstance(String baseDate, String baseFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(baseFormat);
        Date date = sdf.parse(baseDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static void main(String[] args){
        String todayMax;
		try {
			todayMax = DateUtils.dateToString(DateUtils.getTodayMax(new Date()), null);
            System.out.println(todayMax);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
