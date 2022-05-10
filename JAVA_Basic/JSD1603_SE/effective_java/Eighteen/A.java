package effective_java.Eighteen;

public class A {
    private String s;

    public A(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String a() {
        return "a";
    }

    public String aa() {
        return this.a() + "-aa";
    }

    @Override
    public String toString() {
        return "A{" +
                "s='" + s + '\'' +
                '}';
    }
}
