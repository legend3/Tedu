package com.legend.news;

//多线程操作同一个实例对象
//模拟买票
public class TestThread04 implements Runnable{//避免单继承局限性，灵活方便，方便同一个对象被多个线程使用
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
