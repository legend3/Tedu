# lambda :简化代码

## lambda   *λ*   组成：
- 逗号隔开的参数列表   (x,x,x)     ()  
- 箭头符号   ->  
- 方法体 （λ代码块）  

——示例:  

![1583460022040](jdk8.assets/1583460022040.png)

        java   
        package lambda;  
        /*  
         * Created by 颜群  
        */  
    public class Demo01 {  
        public static void test01(){  
            new Thread(new Runnable() {//完成形式--匿名块方形式  
                @Override  
                public void run() {  
                    System.out.println("run....");
                }
            }).start(); 
        }
        public static void test02(){
            new Thread(
    //           ()  -> { System.out.println("run....");  }//lambda完整形式
                 ()  ->  System.out.println("run....")//lambda简化形式
            ).start();
        }
        public static void main(String[] args) {
    //        test01() ;
              test02() ;
        }
    }


    java
        new Thread(
                ()  ->  System.out.println("run....")
        ).start();


以上述为例，new Thread()中是一个接口、抽象类。_但是为了避免不能区分lambda到底是重写的哪个方法，语法上lambda要求重写的接口、抽象类中
有且只能有一个抽象方法_。  

仔细观察，lambda重写的*接口、抽象类*中 会标识一个@FunctionalInterface，称为**函数式接口**。  

>函数式接口：标注@FunctionalInterface，有且只有一个 抽象方法。  

1. **lambda表达式重写的必须是函数式接口(或者只有一个抽象方法的抽象类)**  

>函数式接口要注意以下几点：
2. _即使没有标注@FunctionalInterface，但是只有一个抽象方法，也称之为函数式接口_  
3. 特殊情况：如果某个接口中有多个抽象方法，但**只有1个抽象方法是本接口新定义的**，其他抽象方法和Object中已有的方法重复，那么该接口仍然是函数式接口。  

 
    java
    package lambda;
    /*
     * Created by 颜群
    */
    @FunctionalInterface
    public interface MyInterface  {//everything is an Object
        public abstract void a() ;//本接口新定义的抽象
        public abstract String toString() ;//和Object中重名(实际会调用Object中的toString())
        public abstract boolean equals(Object obj) ;//和Object中重名
        //重点：toString()和equals()看似是抽象方法，实则是 有方法体的具体方法
    }
    class MyInterfaceImpl implements  MyInterface{
        @Override
        public void a() {
            System.out.println("a...");
        }
    }
    class TestMyInterface{
        public static void main(String[] args) {
            MyInterfaceImpl impl = new MyInterfaceImpl();
            impl.a();
            impl.equals("");
            impl.toString();
        }
    }


MyInterface中的a()方法是 **自己定义的**，而其他equals()、toString()方法可以理解为 从Object中继承而来，因此 MyInterface虽然显示了3个抽象，但其实只有1个抽象。  
`()  { return }`


# 函数式接口：_**JDK8新增的函数式编程**_
>函数式接口从哪来？  

## JDK自带 (很多存在于**java.util.function**包中,_由此提供"函数式编程"功能！_)

###四大核心函数式接口：

- 有参，无返回值  （消费型）  
  `java
  @FunctionalInterface
  public interface Consumer<T> {
      void accept(T t);
      ...
  }
  `

- 无参，有返回值（供给型）  
  `java
    @FunctionalInterface
    public interface Supplier<T> {
      T get();
}
  `

- 有参，有返回值  (函数型)  
`java
  @FunctionalInterface
  public interface Function<T, R> {
      R apply(T t);
      ...
  }
  `

- 断言式接口  
`java 
  @FunctionalInterface
  public interface Predicate<T> {
      boolean test(T t);
      ...
  }
`
- 除了上述4种JDK8自带的函数式接口可直接用，**还可以自定义**！！！
  - 如何使用(如下)

## lambda表达式的使用方式

### 方式一
    函数式接口  引用名 =  lambda表达式;
    Predicate<Integer> p = num -> num < 10;

`java
    public static void test01(){
        //   boolean test(T t);
        Predicate<Integer> p = (num) ->  {return num < 10;} ;
        //Predicate<Integer> p = num ->  num < 10  ;
        System.out.println( p.test(3));
    }
`

`java
    public static void test02(){
        //相当于将 MyMath中的add()方法进行了具体的实现
//        MyMath math =  (int n1,int n2) -> {  return  n1+n2 ;} ;
        MyMath math =  (n1,n2) -> {  return  n1+n2 ;} ;
        System.out.println(   math.add(1,100  )       );
    }
`

### 示例：
`
    package lambda;
    import java.util.function.Consumer;
    import java.util.function.Function;
    import java.util.function.Predicate;
    import java.util.function.Supplier;
    /*
     * Created by 颜群
     */
    public class Demo02 {
        public static void test01(){
            //   boolean test(T t);
    //        Predicate<Integer> p = (num) ->  {return num < 10;} ;
            Predicate<Integer> p = num ->  num < 10  ;
            System.out.println( p.test( 3  )   );
        }
        public static void test02(){
            //相当于将 MyMath中的add()方法进行了具体的实现
    //        MyMath math =  (int n1,int n2) -> {  return  n1+n2 ;} ;
             //lambda自带类型推断机制，因此参数的类型 可以省略
            MyMath math =  ( n1,n2) ->     n1+n2  ;
            System.out.println(   math.add(1,100  )       );
        }
        public static void test03(){
            // void accept(T t);
            Consumer<String> c = (x) ->  System.out.println("吃："+x) ;
            c.accept("苹果");
        }
        public static void test04(){
            Supplier<Integer> supplier = ()->  (int)(Math.random()*9000+1000) ;
            System.out.println(   supplier.get() );
        }
        public static void test05(){
            Function<String,String> f = (s) -> s.toUpperCase() ;
            System.out.println(  f.apply("hello world"));
        }
            public static void main(String[] args) {
            test05();
        }
    }
`

### 方式二
`
    new Thread(()  ->  System.out.println("run....")).start(); ;
`

将lambda表达式所代表的函数式接口(自带的+自定义的！)，作为一个方法的参数存在。  
理解：方法B( 方法A(就是一个lambda实现) )：函数式编程。scala  javascript本身就支持函数式编程。  
形式：(编写定义时)方法(函数式接口)  

![1583469965192](jdk8.assets/1583469965192.png)

`
package lambda;  
import java.util.function.Consumer;  
import java.util.function.Function;  
import java.util.function.Predicate;  
import java.util.function.Supplier;  
    /*
     * Created by 颜群
     */
    public class Demo02 {
        public static void test01(){
            //   boolean test(T t);
    //        Predicate<Integer> p = (num) ->  {return num < 10;} ;
            Predicate<Integer> p = num ->  num < 10  ;
            System.out.println( p.test( 3  )   );
        }
    public static void test02(){
        //相当于将 MyMath中的add()方法进行了具体的实现
//        MyMath math =  (int n1,int n2) -> {  return  n1+n2 ;} ;
        MyMath math =  (n1,n2) ->     n1+n2  ;
        System.out.println(   math.add(1,100  )       );
    }
    public static void test03(){
        // void accept(T t);
        Consumer<String> c = (x) ->  System.out.println("吃："+x) ;
        c.accept("苹果");
    }
    public static void test04(){
        Supplier<Integer> supplier = ()->  (int)(Math.random()*9000+1000) ;
        System.out.println(   supplier.get() );
    }
    public static void test05(){
        Function<String,String> f = (s) -> s.toUpperCase() ;
        System.out.println(  f.apply("hello world"));
    }
    public static void test06(){
        String result = upper( (x)-> x.toUpperCase()  ,"hello");
        System.out.println(result);
    }
                                                // fun:函数的逻辑   ,str:hello
    public static String upper( Function<String,String> fun ,String str ){
        return  fun.apply( str  ) ;
    }
    public static void test07(){
        myPredicate( (x) -> x>18   ,  10);
    }
    public static void myPredicate(Predicate<Integer> pre,  Integer num   ){
        System.out.println(   pre.test( num ) );
    }
        public static void main(String[] args) {
        test07();
    }
}
`

# 总结：
- 函数式接口(方法) 由 lambda形式实现！
- 函数式接口(的lambda实现)可以作为方法的参数
