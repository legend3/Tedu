package com.legend.status;

import com.legend.news.TestThread04;

//模拟网络延时: (线程是不安全的, 通过模拟延时)放大问题的发生性
public class TestSleep implements Runnable{
    private int ticket = 10;

    @Override
    public void run() {
        while(true) {
            if(ticket <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买到第" + ticket-- + "票");
        }
    }

    public static void main(String[] args) {
        //一份资源
        TestThread04 testThread04 = new TestThread04();
        //多个代理
        new Thread(testThread04,"小明").start();
        new Thread(testThread04,"老师").start();
        new Thread(testThread04,"黄牛").start();
    }
}
