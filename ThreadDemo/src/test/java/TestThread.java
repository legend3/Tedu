import com.legend.TestLambda03;
import org.junit.Test;

public class TestThread {
    @Test
    public void test01() {
        TestLambda03 l3 = new TestLambda03();
        new Thread(l3.getT(), "t1").start();
        new Thread(l3.getT(), "t2").start();
        new Thread(l3.getT(), "t3").start();
    }

}
