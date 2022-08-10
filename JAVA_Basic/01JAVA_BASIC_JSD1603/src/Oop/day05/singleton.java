package Oop.day05;

/**
 * 单例模式
 * */
public class singleton {
    //创建 singleton 的一个对象（饿汉式）
    private static singleton s = new singleton();

    //让构造函数为 private，这样该类就不会被实例化(只能在本类中被使用)
    private singleton() {
    }

    //获取唯一可用的对象(静态工厂方法)
    public static singleton getInstance(){
        return s;
    }

    public void Hello(){
        System.out.println("Hello World！");
    }

    public static void main(String[] args) {
        singleton s = new singleton();
        s.Hello();
//       singleton.getInstance().Hello();
    }
}
