package effective_java.Eighteen;


import org.junit.Test;

import java.time.Instant;
import java.util.*;

public class testCases {
    @Test
    public void test01() {
        InstrumentedHashSet s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());//期望: 3,实际: 6

//        B b = new B("b");
//        System.out.println(b.aa());
    }

    @Test
    public void test02() {
        Set<Instant> times = new InstrumentedSet2<Instant>(new TreeSet<Instant>());
        System.out.println(times.size());

        Set<String> s2 = new InstrumentedSet2<String>(new HashSet<String>());
        s2.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s2.size());//3
    }
    @Test
    public void test03() {
        CarStyleBrake carStyleBrake = new CarStyleBrake();

        Car car = new Car();
        IBrakeBehavior csb =  car.setBrakeBehavior(carStyleBrake);
        csb.brake();
    }
}
