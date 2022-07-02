package effective_java.Sixteen;

import org.testng.annotations.Test;

public class TestCases {
    @Test
    public void test01() {
        Person person = new Person("父亲", 60, "男");
        System.out.println(person.getBabyAge());
    }
    @Test
    public void test02() {
        Person person = new Person("父亲", 60, "男");
        Time time = new Time(12, 8, person);
        System.out.println(time.hour + ":" + time.minute);
    }
}
