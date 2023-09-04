package threadmethod.p7interrupt;

public class SubThread extends Thread{
/**
 * interrupt()
 * 中断线程. 注意调用 interrupt()方法仅仅是在当前线程打一个停止标志,并不
 * 是真正的停止线程
 */
    @Override
    public void run() {
        super.run();
        for(int i = 1; i<= 10000; i++){
            System.out.println("sub thread -->" + i);
        }
    }
}
