package java并发编程的艺术.challenge01;

public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadlock();
    }

    public void deadlock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println(Thread.currentThread().getName() + ": 1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println(Thread.currentThread().getName() + ": 2");
                    }
                }
            }
        });
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();
    }
}
