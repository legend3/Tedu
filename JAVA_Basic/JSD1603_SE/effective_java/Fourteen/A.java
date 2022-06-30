package effective_java.Fourteen;

public class A implements Comparable{
    private String A;

    public A(String a) {
        A = a;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "A='" + A + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if()
        return 0;
    }
}
