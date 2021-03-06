package lambda;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Created by 颜群
 */
public class Demo02 {
    @Test
    public static void test01(){
        //   boolean test(T t);//断言式
//        Predicate<Integer> p = (num) ->  {return num < 10;};
        Predicate<Integer> p = num ->  num < 10;
        System.out.println( p.test(3));
    }
    @Test
    public static void test02(){
        //相当于将 MyMath中的add()方法进行了具体的实现
//        MyMath math =  (int n1, int n2) -> {return  n1+n2;};
        MyMath math =  (n1,n2) -> n1+n2;
        System.out.println(math.add(1,100));
    }
    @Test
    public static void test03(){
        // void accept(T t);//消费式
        Consumer<String> c = (x) -> System.out.println("吃："+x);
        c.accept("苹果");
    }
    @Test
    public static void test04(){
        Supplier<Integer> supplier = ()->  (int)(Math.random()*9000+1000);//供给型
        System.out.println(supplier.get());
    }
    @Test
    public static void test05(){
        Function<String,String> f = (s) -> s.toUpperCase();//函数型
        System.out.println(f.apply("hello world"));
    }
    @Test
    public static void test06(){
        String result = upper((x)-> x.toUpperCase(),"hello");
        System.out.println(result);
    }
    // fun:函数的逻辑   ,str:hello
    public static String upper(Function<String, String> fun, String str ){
        return fun.apply(str);
    }
    @Test
    public static void test07(){
        myPredicate((x) -> x>18, 10);
    }
    public static void myPredicate(Predicate<Integer> pre, Integer num){
        System.out.println(pre.test(num));
    }

    public static void main(String[] args) {
        test01();
        ArrayList<String> list = new ArrayList<>();
      //  list.add(...);   参数：String，返回值:boolean

        Predicate<String> pre = list::add;// pre.test(  ):参数：String，返回值:boolean
        pre.test("a");
        pre.test("b");

        System.out.println(list);
    }
}
