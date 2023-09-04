package threadmethod.p2IsAlive;

public class Test {
    public static void main(String[] args) {
        SubThread3 t3 = new SubThread3();
        System.out.println("begin==" + t3.isAlive());
        t3.start();
        System.out.println("end==" + t3.isAlive()); //结果不一定,打印这一行时,如果 t3线程还没结束就返回 true, 如果 t3 线程已结束,返回 false
    }


}
