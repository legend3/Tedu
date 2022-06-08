package effective_java.Six;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class TestCases {
    // Performance can be greatly improved!
    static boolean isRomanNumeral01(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // Reusing expensive object for improved performance
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    static boolean isRomanNumeral02(String s) {
        System.identityHashCode(ROMAN);
        return ROMAN.matcher(s).matches();
    }

    private static long sum() {
//        Long sum = 0L;//每次都会创建一个Long包装类对象
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    @Test
    public void test01() {
        //每次new都会创建新的对象
        String s1 = new String("bikini");//DON`T DO THIS
        String s2 = new String("bikini");//DON`T DO THIS
        System.out.println(System.identityHashCode(s1));//返回对象的内存地址
        System.out.println(System.identityHashCode(s2));
    }
    @Test
    public void test01_1() {
        /*不创建新对象*/
        String s1 = "bikini";
        String s2 = "bikini";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }
    @Test
    public void test02() {
        /*每次执行isRomanNumeral01方法内部为正则表达式创建一个Pattern 实例*/
        isRomanNumeral01("dsfsfs");
        isRomanNumeral01("sdfsdfs");
    }
    @Test
    public void test02_2() {
        /*每次执行isRomanNumeral02方法内部都只为正则表达式创建一个Pattern 实例*/
        System.out.println(System.identityHashCode(isRomanNumeral02("dsfsfs")));
        System.out.println(System.identityHashCode(isRomanNumeral02("sdfsdfs")));
    }
    @Test
    public void test03() {
        /*适配器案例*/
    }
    @Test
    public void test04() {
        /*基本类型与包装类型使用时避免创建不必要的对象*/
        //1.执行时间巨大差异
        sum();

        // 2.不相等
        // 使用带参构造器
        Integer a1 = new Integer("1");
        Integer a2 = new Integer("1");

        //使用valueOf()静态工厂方法
        Integer a3 = Integer.valueOf("1");
        Integer a4 = Integer.valueOf("1");

        //结果为false，因为创建了不同的对象
        System.out.println(a1 == a2);

        //结果为true，因为不会新建对象
        System.out.println(a3 == a4);
    }
    @Test
    public void test05() {
        /*数据库连接。建立连接的成本非常高，因此重用这些对象是有意义的*/

    }
}
