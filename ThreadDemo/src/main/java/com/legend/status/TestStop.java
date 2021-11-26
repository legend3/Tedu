package com.legend.status;

//测试stop
/*
    1.建议线程正常停止-->利用次数，不建议死循环
    2.建议使用标志位--->设置一个标志位
    3.不要使用stop或者destroy等过时或者JDK不建议使用的方法
 */

public class TestStop implements Runnable{
    //1.设置一个标识位
    boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while(flag) {//flag为True时，线程会不间断执行输出;false就不执行了
            System.out.println("线程run....." + i++);
        }
    }

    //3.停止方法
    public void stop() {
       flag = false;//通过改变标识符，停止线程(推荐)
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 900) {
                testStop.stop();
                System.out.println("线程停止....");
            }
        }
    }
}
