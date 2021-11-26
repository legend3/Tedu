package com.legend.status;

//测试线程礼让
//当前线程礼让，礼让完后再此进入cpu竞争；因此礼让不一定成功，看cpu心情。
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }

}


class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始...");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止...");
    }
}