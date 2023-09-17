package Template_method_pattern_25.firstDemo;

/**
 * CLassName: Template_method_pattern_25/Account
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/9/5 1:30
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/9/5 1:30      LEGEND        1.0         1.0 Version
 */

/*
    ——模板方法模式的设计模式来对这类情况进行设计：
    某个方法的实现需要多个步骤（类似“请客”），其中有些步骤是固定的（类似“点单”和“买单”），
        而有些步骤并不固定，存在可变性（类似“吃东西”）
 */
//账户类：抽象类
abstract class Account {
    /**
     * 基本方法又可以分为3种：
     *  抽象方法（Abstract Method）
     *  具体方法（Concrete Method）
     *  钩子方法（Hook Method）
     */
    //基本方法——具体方法: 一个具体方法由一个抽象类或具体类声明并实现，其子类可以进行覆盖也可以直接继承
    public boolean validate(String account, String password) {
        System.out.println("账号：" + account);
        System.out.println("密码：" + password);
        if (account.equalsIgnoreCase("张无忌")&&password.equalsIgnoreCase("123456")) {
            return true;
        } else {
            return false;
        }
    }
    //基本方法——具体方法
    public void display() {
        System.out.println("显示利息！");
    }

    //基本方法——抽象方法: 一个抽象方法由抽象类声明，由其具体子类实现。在Java语言里一个抽象方法以abstract关键字标识
    public abstract void calculateInterest();

    //基本方法——钩子方法: 一个钩子方法由一个抽象类或具体类声明并实现，而其子类可能会加以扩展.通过在子类中实现的钩子方法对父类方法的执行进行约束，实现子类对父类行为的反向控制。
        //钩子方法01: 第一类钩子方法可以与一些具体步骤“挂钩”，以实现在不同条件下执行模板方法中的不同步骤。这类钩子方法的返回类型通常是boolean类型，方法名一般为is×××（），用于对某个条件进行判断。
    public boolean isPrint() {
        return true;
    }

    //钩子方法02: 还有一类钩子方法就是方法体为空的具体方法，子类可以根据需要覆盖或者继承这些钩子方法.
    public void primitiveOperation3() {}

    /**
     * 模板方法: 定义在抽象类中的、把基本操作方法组合在一起形成一个总算法或一个总行为的方法
     *      1. 模板方法是一个具体方法，它给出了一个顶层逻辑框架，而逻辑的组成步骤在抽象类中可以是具体方法，也可以是抽象方法
     *      2. 由于模板方法是具体方法，因此模板方法模式中的抽象层只能是抽象类，而不是接口
     */
    public void handle(String account, String password) {
        if (!validate(account, password)) {
            System.out.println("账户或密码错误！");
            return;
        }
        calculateInterest();
        display();
    }
}
