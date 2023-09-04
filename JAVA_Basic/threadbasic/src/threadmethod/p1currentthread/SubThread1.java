package threadmethod.p1currentthread;

/**
 * 定义线程类
 * 分别在构造方法中和 run 方法中打印当前线程
 * Author : 蛙课网老崔
 */
public class SubThread1 extends Thread{
    public SubThread1() {//main线程执行的代码
        System.out.println("构造方法打印当前线程的名称：" + Thread.currentThread());
    }

    @Override
    public void run() {//创建的SubThread1线程执行的代码
        System.out.println("run方法打印当前线程名称：" + Thread.currentThread());
    }
}
