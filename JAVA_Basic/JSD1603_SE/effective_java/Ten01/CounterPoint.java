package effective_java.Ten01;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterPoint extends Point{
    /*
        java.util.concurrent.atomic 的包里有AtomicBoolean, AtomicInteger,AtomicLong,AtomicLongArray,
        AtomicReference等原子类的类，主要用于在高并发环境下的高效程序处理,来帮助我们简化同步处理.
        在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，不可避免的会用到synchronized关键字。
        而AtomicInteger则通过一种线程安全的加减操作接口。
     */
    private static final AtomicInteger counter = new AtomicInteger();
    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    public int numberCreated() {
        return counter.get();
    }
}
