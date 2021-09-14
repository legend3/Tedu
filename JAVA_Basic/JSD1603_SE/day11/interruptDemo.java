package day11;

public class interruptDemo {
    public static void main(String[] args) {
        ThreadDemo s1 = new ThreadDemo();
        ThreadDemo s2 = new ThreadDemo();
        s1.time = 1000;
        s2.time = 5000;
        Thread t1 = new Thread(s1, "T1");
        Thread t2 = new Thread(s2, "T2");

        s1.otherThread = s2;

        t1.start();
        t2.start();

    }
}

class ThreadDemo implements Runnable {
    Thread t;
    int time;
    ThreadDemo otherThread;
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        System.out.println(threadName + " 开始");
        try {
            thread.sleep(time);
            System.out.println(threadName+":还在睡呢~");
//            otherThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(t.getName()+":卧槽！啥事呀叫醒我");
        }
        System.out.println(threadName+" 结束");
    }
}
