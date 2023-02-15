package jucExample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DateUtil {
    //----------------------------------------------------------------
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
    public static  String formatDate(Date date)throws ParseException {
        return sdf.format(date);
    }

    /**
     * 线程不安全
     Exception in thread "pool-1-thread-5" java.lang.NumberFormatException: For input string: ""
     at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
     * */
    public static Date parse(String strDate) throws ParseException{
        return sdf.parse(strDate);
    }
    //----------------------------------------------------------------
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Date parse_thread_safe(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format_thread_safe(Date date) {
        return threadLocal.get().format(date);
    }
    //----------------------------------------------------------------


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i++) {
            executorService.execute(() -> {
                try {
//                    System.out.println(DateUtil.parse("2021-08-03"));
                    System.out.println(DateUtil.parse_thread_safe("2021-08-03"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}


