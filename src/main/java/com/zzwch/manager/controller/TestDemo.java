package com.zzwch.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {

    public static void main(String[] strs){
//        method1();
//        method2();
//        method3();
        parent();
    }


    static void parent(){
        String str = "@123 dsdas@大萨达撒 ";
        Pattern pattern = Pattern.compile("@\\S+\\s");
//        String[] split = pattern.split(str);
//
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }
        Matcher matcher = pattern.matcher(str);
       while ( matcher.find()){
           System.out.println(matcher.start()+"-------"+matcher.end());
           System.out.println(matcher.group());
       }
        System.out.println(str);
    }

    static void method1(){
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dff.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        String ee = dff.format(new Date());
        System.out.println("ee="+ee);
    }

    static void method2(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String rt = sdf.format(calendar.getTime());
        System.out.println("TimeTest.method2() rt="+rt);
    }
    static void method3(){
        String local = "GMT+8";
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(local));
        cal.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
        String date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
        System.out.println("TimeTest.method3() date="+date+",time="+time);
    }
}
