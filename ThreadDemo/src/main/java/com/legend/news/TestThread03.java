package com.legend.news;

public class TestThread03 implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 1000;i++){
            System.out.println("我再看代码---" + i);
        }
    }

    public static void main(String[] args) {
        TestThread03 testThread03 = new TestThread03();
        new Thread(testThread03).start();

        //main线程，主线程
        for(int i = 0;i < 200;i++){
            System.out.println("我再看代码---" + i);
        }
    }
}
