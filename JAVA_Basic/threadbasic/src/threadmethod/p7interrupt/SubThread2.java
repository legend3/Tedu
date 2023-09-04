package threadmethod.p7interrupt;

public class SubThread2 extends Thread{
/**
 * interrupt()
 * 中断线程. 注意调用 interrupt()方法仅仅是在当前线程打一个停止标志,并不是真正的停止线程
 * 作用：可以根据interrupt进行标记，决定是否推出子线程
 */
    @Override
    public void run() {
        super.run();
        for(int i = 1; i<= 10000; i++){
            //判断线程的中断标志
            if(this.isInterrupted()){//标记
                System.out.println("当前线程的中断标志为true，我要推出了.");
                break;  //中断循环，run()方法执行完毕，子线程运行完毕
//                return; //直接结束当前run()方法的执行
            }
            System.out.println("sub thread -->" + i);
        }

    }
}
