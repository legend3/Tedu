package com.legend;

/**
 * 总结: Runnable接口就是一个函数式接口
 *
 */
public class TestLambda02 {
    public static void main(String[] args) {
        ILove ilove = null;
        //1.实现带参接口
        ilove = (int a) -> {
            System.out.println("i love you-->" + a);//实现接口方法
        };
        ilove.love(520);

        //2.简化参数类型
        ilove = (a) -> {
            System.out.println("i love you-->" + a);//实现接口方法
        };
        ilove.love(520);

        //3.简化参数括号
        ilove = a ->{
            System.out.println("i love you-->" + a);
        };
        ilove.love(520);

        //4.简化花括号
        ilove = a -> System.out.println("i love you-->" + a);
        ilove.love(520);

        ILove2 ilove2 = null;
        //5.实现(多个参数)接口
        ilove2 = (a,b) -> {
            System.out.println("i love you-->" + a + b);
        };
        ilove2.love2(520, "xiaoli");
    }
}

//1.定义一个函数式接口
interface ILove {
    void love(int a);
}

interface ILove2 {
    void love2(int a, String b);
}
