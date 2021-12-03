package com.legend.demo02;

/**
 * 静态代理模式:
 * 如果不能直接修改目标类但是又想要修改目标类中的方法的实现，这时候可以使用代理类增强目标类
 * 剖析Thread与Runnable的关系、实现
 */
public class staticProxy {
    public static void main(String[] args) {
        weddingCpmpany wc = new weddingCpmpany(new You());
        wc.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("我结婚了...");//真实对象方法只做自己的事
    }
}

class weddingCpmpany implements Marry{
    private Marry target;

    public weddingCpmpany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {//弥补真实对象方法
        before();
        this.target.HappyMarry();
        after();
    }
    public void before() {
        System.out.println("准备...");
    }
    public void after() {
        System.out.println("送客...");
    }
}