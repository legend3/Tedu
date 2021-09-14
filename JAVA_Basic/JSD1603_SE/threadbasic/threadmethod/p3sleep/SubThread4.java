package threadbasic.threadmethod.p3sleep;

public class SubThread4 extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("run, threadname=" + Thread.currentThread().getName() + ",begin= " + System.currentTimeMillis());
            Thread.sleep(2000);
            //方法执行也需要一定时间 + sleep> 2000
            System.out.println("run, threadname=" + Thread.currentThread().getName() + ",end= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            //因为在Runnab类中run方法是未有抛异常的，因此在子线程的 run 方法中, 如果有受检异常(编译时异常)需要处理,只有选择捕获处理,不能抛出处理!不然没有接收的！！！
            e.printStackTrace();
        }

    }
}
