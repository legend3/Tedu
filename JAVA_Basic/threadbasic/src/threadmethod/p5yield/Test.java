package threadmethod.p5yield;

public class Test {
    public static void main(String[] args) {
        //开启子线程，计算累加和
        SubThread6 t6 = new SubThread6();
        t6.start();
        //main
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <100000000; i++) {
            sum++;
        }
        long end = System.currentTimeMillis();
        System.out.println("main方法用时：" + (end - begin));
    }
}
