package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Created by 颜群
 */
public class Demo02 {
    @Test
    public void test01(){
        //   boolean test(T t);//断言式
//        Predicate<Integer> p = (num) ->  {return num < 10;};
        Predicate<Integer> p = num ->  num < 10;//匿名内部类实现接口方法: new 接口 - 参数 -  实现的方法体
        System.out.println(p.test(3));
    }
    @Test
    public void test02(){
//        MyMath math =  (int n1, int n2) -> {return  n1+n2;};
        MyMath<Integer> math =  (n1,n2) -> n1+n2;//（自定义）函数型
        System.out.println(math.add(1,100));
    }
    @Test
    public void test03(){
        // void accept(T t);//消费式
        Consumer<String> c = (x) -> System.out.println("吃："+x);
        c.accept("苹果");
    }
    @Test
    public void test04(){
        Supplier<Integer> supplier = ()->  (int)(Math.random()*9000+1000);//供给型
        System.out.println(supplier.get());
    }
    @Test
    public void test05(){
        Function<String,String> f = (s) -> s.toUpperCase();//函数型
        System.out.println(f.apply("hello world"));
    }
    // fun:函数的逻辑, str:hello
    public String upper(Function<String, String> fun, String str ) {//高阶函数的一种特殊形式
        return fun.apply(str);
    }
    @Test
    public void test06(){
        String result = upper((x) -> x.toUpperCase(),"hello");//将函数式接口new、实现、调用，全部封装在upper()方法中
        System.out.println(result);
    }

    public void myPredicate(Predicate<Integer> pre, Integer num) {//虚参
        System.out.println(pre.test(num));
    }
    @Test
    public void test07() {
        myPredicate((x) -> x>18, 10);//myPredicate(函数式接口的实现——"类似匿名块实现", num)//实参
    }
    @Test
    public void test08() {
        /**
         * Java方法引用: 方法引用被实现为 Lambda 表达式的语法糖，即当一个 Lambda 表达式只调用一个已经存在的方法时
         */
        ArrayList<String> list = new ArrayList<>();
//      list.add("...");//参数: String，返回值: boolean

        //断言式
        Predicate<String> pre = list::add;// pre.test(T t):参数：String，返回值:boolean
        pre.test("a");
        pre.test("b");

        //函数式
        Function<String, Boolean> fun = list::add;// fun.apply(T t):参数：String，返回值:boolean
        fun.apply("c");
        fun.apply("d");

        System.out.println(list);//[a, b, c, d]
    }
    @Test
    public void test09() {
        String str = "hello world";
        Function<Integer, Character> fun = str::charAt;//index -> str.charAt(index);
        fun.apply(1);

    }
    @Test
    public void test10() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(System.out::println);//list.forEach((x) -> System.out.println(x));
        // Consumer<Integer> consumer = System.out::println;

    }
    @Test
    public void test11() {
//        Supplier<List<String>> supplier = () -> new ArrayList<>();
        Supplier<List<String>> supplier = ArrayList::new;
        supplier.get();//返回一个ArrayList空构造方法new出来的实例
    }
}