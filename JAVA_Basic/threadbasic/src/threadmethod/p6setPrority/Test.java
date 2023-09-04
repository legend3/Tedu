package threadmethod.p6setPrority;

public class Test {
    public static void main(String[] args) {
        ThreadA threadA = new  ThreadA();
        /*
            优先级值：
                Max：10
                Min：1
                Default：5
         */
        threadA.setPriority(1);
        threadA.start();

        ThreadB threadB = new  ThreadB();
        threadB.setPriority(10);//优先级越高获取cpu资源越多(被调用的次数越多)
        threadB.start();
    }
}
