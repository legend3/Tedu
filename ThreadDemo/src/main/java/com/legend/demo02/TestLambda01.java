package com.legend.demo02;

public class TestLambda01 {
    //1.2 静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("Like2静态内部实现类");
        }
    }

    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lambda();

        iLike = new Like2();
        iLike.lambda();

        //1.3 局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("like3局部内部实现类");
            }
        }
        iLike = new Like3();
        iLike.lambda();

        //1.4 匿名内部类
        iLike = new ILike() {
            @Override
            public void lambda() {
                System.out.println("匿名内部实现类");
            }
        };
        iLike.lambda();
        //1.5 用lambda简化(初始lambda！)
        //对于函数式接口，我们可以通过lambda表达式来创建该接口的对象
        iLike = ()->{
            System.out.println("lambda实现类");
        };
        iLike.lambda();
    }
}

/**
 * 1.定义一个函数式接口
 * 任何接口，如果只包含唯一一个抽象方法，那么它就是一个函数式接口
 */


interface ILike {
    void lambda();
}

//1.1 成员实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("LIKE成员内部实现类");
    }
}