package threadbasic.createthread.p3;

/**
 * 测试实现 Runnable 接口的形式创建线程
 * Author : 蛙课网老崔
 */
public class Test {
    public static void main(String[] args) {
//3)创建 Runnable 接口的实现类对象
        MyRunnable runnable = new MyRunnable();
//4)创建线程对象
        Thread thread = new Thread(runnable);
//5)开启线程
        thread.start();
//当前是 main 线程
        for (int i = 1; i <= 1000; i++) {
            System.out.println("main==> " + i);
        }
//有时调用 Thread(Runnable)构造方法时,实参也会传递匿名内部类对象
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    System.out.println("sub-------- " + i);
                }
            }
        });
        thread2.start();
    }
}
