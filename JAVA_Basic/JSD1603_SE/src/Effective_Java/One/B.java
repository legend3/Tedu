package Effective_Java.One;

public class B implements A{
    @Override
    public void a() {
        System.out.println("B实现接口A的默认方法a()");
    }

    @Override
    public void c() {
        System.out.println("B实现接口A的方法a()");
    }
}