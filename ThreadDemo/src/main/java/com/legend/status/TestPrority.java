package com.legend.status;
//测试线程的优先级
public class TestPrority {
    public static void main(String[] args) {
        //1.主线程的优先级
        System.out.println("main线程的优先级: " + Thread.currentThread().getPriority());
        //2.各线程的优先级
        MyPrority myPrority = new MyPrority();
        Thread t1 = new Thread(myPrority,"t1");
        Thread t2 = new Thread(myPrority,"t2");
        Thread t3 = new Thread(myPrority,"t3");
        Thread t4 = new Thread(myPrority,"t4");
        Thread t5 = new Thread(myPrority,"t5");
        Thread t6 = new Thread(myPrority,"t6");

        //2.1 先设置优先级，再启动    (性能倒置: cpu先执行优先级低的后才执行了优先级高的！)
        t1.start();//就用默认优先级

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);//MAX_PRIORITY=10
        t4.start();

//        t5.setPriority(-1);
//        t5.start();
//
//        t6.setPriority(11);
//        t6.start();
    }
}

class MyPrority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}