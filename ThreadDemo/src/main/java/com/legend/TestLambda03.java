package com.legend;

public class TestLambda03 {
    //重写run()方法的属性
    private Runnable t = () -> {
        System.out.println(Thread.currentThread().getName()+"的run()方法执行!");
    };

    public Runnable getT() {
        return t;
    }
}
