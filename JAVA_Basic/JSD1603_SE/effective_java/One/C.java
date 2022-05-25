package effective_java.One;

public class C {

    public static C getC(D d) {//静态工厂方法，返回子类
        return d;
    }

    public void c() {
        System.out.println("C类的方法c()");
    }
}
