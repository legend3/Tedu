package lambda;

/*
 * 自定的函数式接口
 */

@FunctionalInterface
public interface MyInterface  {//everything is an Object
    public abstract void a() ;//本接口新定义的抽象(函数式接口方法)

    public abstract String toString() ;//和Object中重名
    public abstract boolean equals(Object obj) ;//和Object中重名

    //重点：toString()和equals()看似是抽象方法，实则是 有方法体的具体方法
}

class MyInterfaceImpl implements MyInterface{
    @Override
    public void a() {
        System.out.println("a...");
    }
    public void test() {
        MyInterface m = () -> System.out.println("a...");
        m.a();
    }
}

class TestMyInterface{
    public static void main(String[] args) {
        //普通方式
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.a();
        impl.test();
        impl.equals("");//实际会调用Object中的equals()
        impl.toString();//实际会调用Object中的toString()

        //lamnda方式
        MyInterface m = () -> System.out.println("a...");//相当于实现了a(),然后new MyInterface()子实例m;
        m.a();//实现后的子类实例调用实现了的a()方法
    }
}
