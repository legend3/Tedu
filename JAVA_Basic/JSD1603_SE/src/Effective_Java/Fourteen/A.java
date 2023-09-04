package Effective_Java.Fourteen;

public class A implements Comparable<A>{
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

    @Override
    public String toString() {
        return "A{" +
                "s='" + s + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return s.equals(a.s);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + s.hashCode();
        return result;
    }

    @Override
    public int compareTo(A a) {
        return s.compareTo(a.s);//递归调用String的compareTo方法
    }
}
