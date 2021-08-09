package com.hewie.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class DataTimePratise {
    public static void main(String[] args) {
//        LocalDateTime localDateTime = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
//        LocalDateTime localDate = localDateTime.plusDays(1);
//        System.out.println(localDate);
//        LocalDateTime dateTime = localDate.withDayOfMonth(31);
//        System.err.println(dateTime);
//        LocalDateTime daH = dateTime.withMonth(9);
//        System.err.println(daH);
//        ZonedDateTime zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")); // 默认时区
//        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
//        System.out.println(zbj);
//        System.out.println(zny);
//        Instant instant = Instant.now();
//        System.out.println(instant.toEpochMilli());
//        System.err.println(instant.getEpochSecond());
//        System.out.println(Instant.now().toEpochMilli());
//        Map<DayOfWeek,String> dayMap = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
//        dayMap.put(DayOfWeek.WEDNESDAY,"星期一");
//        dayMap.put(DayOfWeek.THURSDAY,"星期二");
//        System.out.println(dayMap.toString());
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banlance");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
