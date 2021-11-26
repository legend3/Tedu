package com.legend.status;
//观察线程的状态
public class TestStatue {
    public static void main(String[] args) throws InterruptedException {
        //1.创建一个线程
        Thread thread = new Thread(()->{//lambda实现一个Runnable接口的run
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });

        //2.观察状态
        Thread.State state = thread.getState();
        System.out.println("未启动的线程状态：" + state);//NEW

        //3.观察启动后的状态
        thread.start();
        state = thread.getState();
        System.out.println(state);//Run

        //4.只要线程不终止，就一致输出状态
        while(state != Thread.State.TERMINATED) {//TERMINATED: 线程终止
            Thread.sleep(100);
            state = thread.getState();//更新线程状态
            System.out.println("线程状态：" + state);//TIMED_WAITING(thread执行过程中<等待5*1000ms>)
        }
        //5.死亡之后的线程是不能再次启动了
        thread.start();//dead
    }
}
