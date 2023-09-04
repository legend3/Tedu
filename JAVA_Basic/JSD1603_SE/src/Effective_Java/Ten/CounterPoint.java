package Effective_Java.Ten;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 子类情况
 *
 * 里氏替代原则（ Liskov substitution principle）指出，任何类型的重要属性都应该适用于所有的子类型，因此任何
 * 为这种类型编写的方法都应该在其子类上同样适用[Liskov87]。
 * 这是我们之前声明的一个正式陈述，即 Point 的子类
 * （如 CounterPoint）仍然是一个 Point，必须作为一个 Point 类来看待。
 */

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
        counter.incrementAndGet();//计数器，加1
    }
    public static int numberCreated() {
        return counter.get();
    }
}
