package threadbasic.threadmethod.p4getId;

/**
 * thread.getId()可以获得线程的唯一标识
 * 注意:
 * 某个编号的线程运行结束后,该编号可能被后续创建的线程使
 * 用
 * 重启的 JVM 后,同一个线程的编号可能不一样
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());

        //子线程id
        for (int i = 0; i < 50; i++) {
            new SubThread5().start();
        }
    }
}
