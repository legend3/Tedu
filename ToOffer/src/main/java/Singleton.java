/**
 * 前言:只能创建同一个实例(且线程安全)
 * 单例模式:线程安全的懒汉式
 */
public class Singleton {
    private Singleton() {//封闭
    }

    private static class singletonHolder {//静态私有内部类(扩展类功能)
        private static Singleton outInstance =new Singleton();//可以设置静态变量，调用也不需要实例singletonHolder！
    }

    public static Singleton getInstance() {//唯一出口
        return singletonHolder.outInstance;
    }

//    public static void main(String[] args) {
//        Singleton singleton = new Singleton();
//        System.out.println(singleton);
//    }
}
