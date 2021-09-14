package threadbasic.threadmethod.p3sleep;

public class Test {
    public static void main(String[] args) {
        SubThread4 t4 = new SubThread4();
        System.out.println("main-begin= " + System.currentTimeMillis());
//        t4.start();
        t4.run();//为开启多线程并发执行，而是串行依次创建线程执行！！！
        System.out.println("main-end= " + System.currentTimeMillis());
    }
}
