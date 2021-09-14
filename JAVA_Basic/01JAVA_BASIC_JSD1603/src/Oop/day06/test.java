package Oop.day06;

public class test {
    private String s = "常量变量";
    private int i;

    test2 t2 = new test2() {//test内中定义一个test2类的子类为匿名类
        @Override
        int t(int n) {
            int ii = i + n;
            System.out.println(ii);
            return ii;
        }
    };

    test3 t3 = new test3() {//test内中定义一个test2类的子类为匿名类
        @Override
        public String s(String str) {
            String sss = s + str;
            System.out.println(sss);
            return sss;
        }
    };

    public static void main(String[] args) {
        test tt = new test();
        int n = 1;
        String str = "3";
        tt.t2.t(n);
        tt.t3.s(str);
    }
}


abstract class test2{//要被匿名的类
    abstract int t(int n);
}

interface test3{
    String s(String str);
}