package effective_java.Eighteen;

public class B extends A {
    public B(String s) {
        super(s);
    }

    @Override
    public String a() {
        System.out.println("bbbbb");
        return super.a();
    }

    @Override
    public String aa() {
        return super.aa();
    }

    public static void main(String[] args) {
        B b = new B("b");
        System.out.println(b.getClass());
        System.out.println(b.aa());
    }
}
