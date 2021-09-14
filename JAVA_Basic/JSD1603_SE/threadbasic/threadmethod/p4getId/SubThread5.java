package threadbasic.threadmethod.p4getId;

public class SubThread5 extends Thread{
    @Override
    public void run() {
        System.out.println("thread name = " + Thread.currentThread().getName() +  ", id == " + Thread.currentThread().getId());
    }
}
