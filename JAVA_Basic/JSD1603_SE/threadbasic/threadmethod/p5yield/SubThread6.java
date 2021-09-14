package threadbasic.threadmethod.p5yield;

public class SubThread6 extends Thread{
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <1000000; i++) {
            sum++;
            Thread.yield();     //线程让步，放弃（本次）CPU的执行权(线程等待cup线程调度器下次再给此线程调用、分配)！！！
        }
        long end = System.currentTimeMillis();
        System.out.println("新线程用时：" + (end - begin));
    }
}
