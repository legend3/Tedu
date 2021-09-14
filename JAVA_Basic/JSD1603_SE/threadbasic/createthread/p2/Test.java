package threadbasic.createthread.p2;

public class Test {
    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2();
        thread2.start();    //开启子线程

        //当前是main线程
        try {
            for(int i = 1;i <= 10; i++) {
                System.out.println("main--:" + i);
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time); //线程睡眠，单位是毫秒，1秒 = 1000ms
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //因为线程被执行调度机制，每次执行出现的输出顺序都是无序！
    }
}
