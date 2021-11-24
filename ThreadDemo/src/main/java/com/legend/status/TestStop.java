package com.legend.status;

//测试stop
/*
    1.建议线程正常停止-->利用次数，不建议死循环
    2.建议使用标志位--->设置一个标志位
    3.不要使用stop或者destroy等过时或者JDK不建议使用的方法
 */

public class TestStop implements Runnable{
    //1.设置一个标识位

    @Override
    public void run() {

    }

    public static void main(String[] args) {

    }
}
