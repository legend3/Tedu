package com.legend.news;

//创建线程方式以:继承Thread类，重写run()方法，调用start开启线程
public class TestThread01 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for(int i = 0;i < 200;i++){
            System.out.println("我再看代码-" + i);
        }
    }

    public static void main(String[] args) {
        //创建一个线程对象
        TestThread01 testThread1 = new TestThread01();

        //调用start()方法开启线程
        testThread1.start();

        //main线程，主线程
        for(int i = 0;i < 1000;i++){
            System.out.println("我再看代码---" + i);
        }
    }
}
