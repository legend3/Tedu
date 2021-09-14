package java并发编程的艺术.challenge01;

/**
 * 一、并发编程的挑战：上下文切换
 * 为什么(此处)并行执行的速度比串行慢呢？
 *  因为线程有创建和上下文切换的开销
 *
 * 如何减少上下文切换：
 * 1.无锁并发编程：多线竞争锁时，会引起上下文切换，所以多线程处理数据时，
 * 可以用一些办法来避免使用锁，如将数据的ID按照Hash算法取模分段，不同的线程处理不同的数据。
 * 2.CAS算法，Java的Atomic包使用CAS算法来更新数据，而不需要加锁
 * 3.使用最少线程，任务少，创建了很多线程来处理，这样会造成大量线程都处于等待状态
 * 4.协程，在单线程里实现多任务调度，并在单线程里维持多个任务间的切换
 */
class Concurrency_SerialTest {
    private static final long count = 10000L;
    public static void main(String[] args) throws InterruptedException {
        concurrent();
        serial();
    }

    private static void concurrent() throws InterruptedException {//并行执行
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {//1.创建
            @Override
            public void run() {
                int a = 0;
                for(long i=0; i< count; i++){
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for(long i=0; i<count; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();//2.上下文切换
        System.out.println("concurrent:" + time + "ms, b="+b);
    }

    private static void serial() {//串行执行
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i=0; i< count; i++){
            a += 5;
                }
        int b = 0;
        for(long i=0; i<count; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms, b=" + b + ",a=" + a);
    }
}
