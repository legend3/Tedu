package threadmethod.p8daemon;

public class Test {
    public static void main(String[] args) {
        SubDemoThread thread = new SubDemoThread();
        //设置线程为守护线程
        thread.setDaemon(true);
        thread.start();

        //当前线程为main线程
        for(int i = 0; i <= 10; i++){
            System.out.println("main ==>" + i);
        }
    }
}
