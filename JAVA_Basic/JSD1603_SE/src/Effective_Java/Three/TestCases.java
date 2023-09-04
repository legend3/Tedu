package Effective_Java.Three;


import org.junit.Test;

public class TestCases {
    @Test
    public void test01() {
        System.out.println(Elvis01.INSTANCE);
        System.out.println(Elvis01.INSTANCE);
    }
    @Test
    public void test02() {
        System.out.println(Elvis02.getInstance());
        System.out.println(Elvis02.getInstance());
        Runnable getInstance = Elvis02::getInstance;
//        System.out.println(Elvis02::getInstance);
//        System.out.println(Supplier<Elvis02>);
    }
    @Test
    public void test03() {
        System.out.println(Elvis03.INSTANCE);
        System.out.println(Elvis03.INSTANCE.getI());
        System.out.println(Elvis03.INSTANCE.getS());
    }
}
