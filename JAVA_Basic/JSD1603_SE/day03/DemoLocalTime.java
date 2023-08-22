package day03;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * CLassName: day03/LocalTime
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/8/12 18:48
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/8/12 18:48      LEGEND        1.0         1.0 Version
 */
public class DemoLocalTime {
    public static void main(String[] args) {
        // 获取当前时间,包含毫秒数---打印输出-> 08:59:30.598
        LocalTime now = LocalTime.now();

        // 构建时间---打印输出-> 12:30:59
        LocalTime localTime = LocalTime.of(13, 30, 59);

        // 获取当前时间,不包含毫秒数---打印输出-> 09:03:49
        LocalTime localTime1 = now.withNano(0);

        // 字符串转为时间,还可以有其他格式,比如12:15, 12:15:23.233
        // 打印输出-> 12:15:30
        LocalTime localTime2 = LocalTime.parse("12:15:30");

        // 判断localTime是否比localTime1晚
        System.out.println(localTime.isAfter(localTime1));

        // 判断localTime是否比localTime2晚
        System.out.println(localTime.isBefore(localTime2));

        // 修改毫秒值
        System.out.println(localTime.withNano(22345));

        // 支持的最大本地时间：23:59:59.999999999
        System.out.println(LocalTime.MAX);

        // 支持的最小本地时间：00:00
        System.out.println(LocalTime.MIN);

        // 午夜时间：00:00
        System.out.println(LocalTime.MIDNIGHT);

        // 正午时间：12:00
        System.out.println(LocalTime.NOON);

        // Temporal	adjustInto(Temporal temporal)
        // 将指定的 temporal 对象调整为与此对象具有相同的时间的新temporal对象。
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        // 2019-10-17T10:24:19.361+08:00[Asia/Shanghai]
        System.out.println(zonedDateTime);
        // 2019-10-17T12:30:59+08:00[Asia/Shanghai]
        System.out.println(localTime.adjustInto(zonedDateTime));

        // 将time与date结合来创建LocalDateTime。打印输出->2019-10-17T12:30:59
        LocalDateTime localDateTime = localTime.atDate(LocalDate.now());

        // 将时间与偏移量组合在一起来创建OffsetTime 打印输出->12:30:59+02:00
        System.out.println(localTime.atOffset(ZoneOffset.ofHours(2)));

        // 两个时间进行比较 大返回1，小就返回-1，一样就返回0
        System.out.println(localTime.compareTo(localTime1));

        // LocalTime    withSecond(int second)
        // LocalTime	withNano(int nanoOfSecond)
        // LocalTime	withMinute(int minute)
        // LocalTime	withHour(int hour)
        // 上面这4个方法分别是修改该时间的秒，毫秒，分钟，小时
        System.out.println(localTime.withHour(11)); // 11:30:59

        // 将时间修改为指定时间
        System.out.println(localTime.with(LocalTime.NOON));  // 12:00
        // 02:30:59
        System.out.println(localTime.with(ChronoField.HOUR_OF_DAY,2));
        // 添加指定时间 打印输出->15:30:59
        System.out.println(localTime.plus(Duration.ofHours(2)));
        // 添加指定时间 打印输出->16:30:59
        System.out.println(localTime.plus(3, ChronoUnit.HOURS));
//        localTime.plusNanos();  // 添加毫秒
//        localTime.plusSeconds();  // 添加秒
//        localTime.plusMinutes();  // 添加分钟
//        localTime.plusHours();  // 添加小时

//        localTime.minus();  减少指定时间
//        localTime.minus();  减少指定时间
//        localTime.minusNanos();  减少指定毫秒数
//        localTime.minusSeconds();  减少指定秒数
//        localTime.minusMinutes();  减少指定分钟数
//        localTime.minusHours();  减少指定小时数




    }
}
