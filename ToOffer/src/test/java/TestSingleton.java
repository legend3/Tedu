import org.junit.Test;

public class TestSingleton{
    @Test
    public void test01() {
        ThreadSingle threadSingle = new ThreadSingle();
        new Thread(threadSingle,"t1").start();
        new Thread(threadSingle,"t2").start();
    }
}
