package threadmethod.p1currentthread;

/**
 * thread.setName(线程名称), 设置线程名称
 * thread.getName()返回线程名称
 * 通过设置线程名称,有助于程序调试,提高程序的可读性, 建议为
 * 每个线程都设置一个能够体现线程功能的名称
 */
public class Test02CurrentThread {
    public static void main(String[] args) throws InterruptedException {
        SubThread2 t2 = new SubThread2();//创建出新线程
        t2.setName("t2");//设置线程的名称
        t2.start();//启动线程，去执行run()方法

        Thread.sleep(500);//main 线程睡眠 500 毫秒

        //Thread(Runnable)构造方法形参是 Runnable 接口,调用时传递的实参是接口的实现类对象
        Thread t3 = new Thread(t2);
        t3.start();//启动t3线程后，去执行的是t2线程的run方法(没有Runnable实参时，才执行t3自己的run方法)！！
    }
}
