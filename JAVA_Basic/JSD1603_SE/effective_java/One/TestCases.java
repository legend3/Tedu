package effective_java.One;


import org.junit.Test;

public class TestCases {
    @Test
    public void test01() {
        Boolean b = BooleanDemo.getBoolean(true);
        System.out.println(b);
    }
    @Test
    public void test02() {
        Boolean b1 = BooleanDemo.getBoolean2(true);
        Boolean b2 = BooleanDemo.getBoolean2(true);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);
    }
    @Test
    public void test03() {
        System.out.println(BooleanDemo.getBoolean3());
    }
    @Test
    public void test033() {
        A a = A.getA(new B());
        System.out.println(a);

        C c = C.getC(new D());
        System.out.println(c);
    }
    @Test
    public void test04() {
        System.out.println(BooleanDemo.getBoolean4("X"));
    }
//    @Test
//    public void test05() {
//        A a = BooleanDemo.getBoolean5(A)
//    }
}
