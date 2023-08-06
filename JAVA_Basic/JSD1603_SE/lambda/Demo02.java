package lambda;

import org.junit.Test;

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
    public void test01(){
        //   boolean test(T t);//断言式
//        Predicate<Integer> p = (num) ->  {return num < 10;};
        Predicate<Integer> p = num ->  num < 10;//匿名内部类实现接口方法: new 接口 - 参数 -  实现的方法体
        System.out.println(p.test(3));
    }
    @Test
    public void test02(){
//        MyMath math =  (int n1, int n2) -> {return  n1+n2;};
        MyMath math =  (n1,n2) -> n1+n2;//（自定义）函数型
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
    @Test
    public void test06(){
        String result = upper( (x) -> x.toUpperCase(),"hello");//将函数式接口new、实现、调用，全部封装在upper()方法中
        System.out.println(result);
    }
    // fun:函数的逻辑   ,str:hello
    public String upper(Function<String, String> fun, String str ) {
        return fun.apply(str);
    }
    @Test
    public void test07(){
        myPredicate((x) -> x>18, 10);//myPredicate(匿名内部类, num)//实参
    }
    public void myPredicate(Predicate<Integer> pre, Integer num) {//虚参
        System.out.println(pre.test(num));
    }

    public void main(String[] args) {
        test01();
        ArrayList<String> list = new ArrayList<>();
      //  list.add(...);   参数：String，返回值:boolean

        Predicate<String> pre = list::add;// pre.test(  ):参数：String，返回值:boolean
        pre.test("a");
        pre.test("b");

        System.out.println(list);
    }
}
