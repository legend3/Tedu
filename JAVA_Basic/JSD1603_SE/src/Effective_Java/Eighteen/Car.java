package Effective_Java.Eighteen;

/**
 * 转发类
 *
 * 注意：上面的刹车行为不一定需要通过接口来实现，定义一个BrakeBehaviour的父类，然后再定义AStyleBrake，BStyleBrake来继承该类，
 * 实现不同的行为， 同样是组合方式的应用。所以不难发现， 当我们拿类继承和组合在一起进行对比时， 并不是以实现方式中是否有用到类继承来区分的。
 *
 * 我们真正关注的重点是行为的继承与行为的组合: 需要变化的行为是通过继承后重写的方式实现，还是通过 赋予不同的行为实例实现(转发)。
 */
public class Car {
    protected IBrakeBehavior brakeBehavior;//2.新类增加一个私有属性，该属性是 现有类的实例引用！！！

//    public void brake() {
//        brakeBehavior.brake();
//    }

    public IBrakeBehavior setBrakeBehavior(final IBrakeBehavior brakeType) {
        this.brakeBehavior = brakeType;
        return this.brakeBehavior;
    }
}
