package com.legend.status;

//测试线程的join方法,Join合并线程，待线程执行完后，再执行其他线程，其他线程处于阻塞状态--想象成插"队"
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "线程: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread =  new Thread(testJoin,"vip");
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if(i == 200) {
                thread.join();
            }
            System.out.println("main线程输出: " + i);
        }
    }
}
