package threadbasic.threadmethod.p6setPrority;
/**
 *      thread.setPriority( num ); 设置线程的优先级
 * java 线程的优先级取值范围是 1 ~ 10 , 如果超出这个范围会抛出异常 IllegalArgumentException.
 * 在操作系统中,优先级较高的线程获得 CPU 的资源越多
 * 线程优先级本质上是只是给线程调度器一个提示信息,以便于调
 * 度器决定先调度哪些线程. 注意不能保证优先级高的线程先运行.
 *
 *      Java 优先级设置不当或者滥用可能会导致某些线程永远无法得到
 * 运行,即产生了线程饥饿. 线程的优先级并不是设置的越高越好,一般情况下使用普通的优
 * 先级即可,即在开发时不必设置线程的优先级.
 * 线程的优先级具有继承性, 在 A 线程中创建了 B 线程,则 B 线程的优先级与 A 线程是一样的.
 */
public class ThreadA extends Thread{
    private Thread threadAA;

    @Override
    public void run() {
        this.threadAA = new Thread();
        System.out.println("threadAA线程的优先级：" + this.threadAA.getPriority());
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum++;
        }
        long end = System.currentTimeMillis();
        System.out.println("threadA用时：" + (end - begin));
    }
}
