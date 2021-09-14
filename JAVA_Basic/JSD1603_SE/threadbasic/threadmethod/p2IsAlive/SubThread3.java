package threadbasic.threadmethod.p2IsAlive;

public class SubThread3 extends  Thread{
    @Override
    public void run() {
        System.out.println("run 方法, isalive=" + this.isAlive());
    }
}
