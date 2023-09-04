package Effective_Java.One;

public interface A {

    /**
     * java 8新增，接口静态方法(不能实现)
     * @param b
     * @return
     */
    static A getA(B b) {//静态工厂方法，返回实现类实例——好处：3
        return b;
    }

    /**
     * java 8新增，接口默认方法(非必需实现)
     */
    default void a() {
        System.out.println("A接口默认方法a()");
    }

    /**
     * 必需实现的方法
     */
    void c();
}
