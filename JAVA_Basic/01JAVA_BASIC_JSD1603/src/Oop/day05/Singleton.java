package Oop.day05;

/**
 * 单例模式
 * */
public class Singleton {
    //创建 singleton 的一个对象（饿汉式）
    private static Singleton singleton = new Singleton();
    //创建 singleton 的一个对象（懒汉式）
//    private static Singleton singleton = null;

    //让构造函数为 private，这样该类就不会被实例化(只能在本类中被使用)
    private Singleton() {
    }

    //获取唯一可用的对象(静态工厂方法)
    public static Singleton getInstance(){
        //懒汉式
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
        //饿汉式
        return singleton;
    }

    public void Hello(){
        System.out.println("Hello World！");
    }

    public static void main(String[] args) {
//        Singleton s1 = new Singleton();
//        Singleton s2 = new Singleton();
//        System.out.println(s1 == s2);
//        s1.Hello();
//        s2.Hello();

        //使用单例模式创建对对象
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
        s1.Hello();
        s2.Hello();
    }
}
