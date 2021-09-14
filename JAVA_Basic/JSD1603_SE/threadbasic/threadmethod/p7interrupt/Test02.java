package threadbasic.threadmethod.p7interrupt;

public class Test02 {
    public static void main(String[] args) {
        SubThread2 t1 = new SubThread2();
        t1.start();

        //当前线程是的main线程
        for(int i = 1; i <= 100; i++){
            System.out.println("main ==>" + i);
        }
        //中断子线程（发出信号）
        t1.interrupt(); //仅仅是给子线程标记中断，子线程没有真正中断
    }
}
