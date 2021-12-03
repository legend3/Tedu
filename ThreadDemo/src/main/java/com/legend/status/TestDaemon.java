package com.legend.status;

/**
 * 测试守护线程
 * 线程分为用户线程和守护线程
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 * 如,后台记录操作日志,监控内存,垃圾回收等待..
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);//上帝守护着

        Man man = new Man();
        Thread manThread = new Thread(man);

        godThread.start();
        manThread.start();
    }
}
class God implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("上帝永存....");//用户线程执行完毕后虚拟机就开始慢慢关闭，就不会再输出了
        }
    }
}

class Man implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着....");
        }
        System.out.println("该死了....");
    }
}