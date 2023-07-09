package Oop.day06;
/**
    接口的封装和可重用性是接口的主要优点。但接口的缺点是实现接口的类必须实现所有接口方法。有时只需要接口的部分方法，但在实现接口时必须提供所有接口方法的方法实现。虚拟扩展方法解决了这个问题。

    虚拟扩展方法是接口中具有默认实现的方法。如果实现类不提供方法的实现，则使用默认的实现。实现类可以重写默认实现，或提供新的默认实现。

    虚拟扩展方法添加配置来扩展接口的功能，而不会破坏已实现接口较早版本的类的向后兼容性。虚拟扩展方法中的默认实现是用 default 关键字提供的。由于虚拟扩展方法提供默认实现，因此不能是抽象方法。

    Java8中的许多接口都提供了默认的实现方法，如java.util.Map：
    这里写图片描述

    java.util.List:
    这里写图片描述

    如下代码清单定义了一个具有默认实现的接口Animal，并定义了两个接口实现类Bird和Pig，其中Bird未重新实现接口中的方法name()，而Pig中重新实现了接口中的方法name()：
*/
interface Animal {
    void getEat();
    void getSleep();
    /*
       定义一个默认实现的接口(当然可以重写它)
     */
    default void name(){
        System.out.println("I do not want to tell you.");
    }
}

class Bird implements Animal{
    @Override
    public void getEat() {
        System.out.println("Bird is getEating.");
    }

    @Override
    public void getSleep() {
        System.out.println("Bird is getSleeping.");
    }
}

class Pig implements Animal{
    @Override
    public void getEat() {
        System.out.println("Pig is getEating.");
    }

    @Override
    public void getSleep() {
        System.out.println("Pig is getSleeping.");
    }

    @Override
    public void name() {
        System.out.println("My name is pig.");
    }
}

public class VirtualImpl {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.getEat();
        bird.getSleep();
        bird.name();

        System.out.println("----------------");

        Pig pig = new Pig();
        pig.getEat();
        pig.getSleep();
        pig.name();
    }
}
