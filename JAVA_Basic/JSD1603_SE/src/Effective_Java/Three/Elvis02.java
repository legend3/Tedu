package Effective_Java.Three;

/**
 * 第二种方式：静态工厂方法
 */
public class Elvis02 {
    public static final Elvis02 INSTANCE = new Elvis02();

    private Elvis02() {
    }

    public static Elvis02 getInstance() {//用静态工厂方法获取静态属性(类实例)
        return INSTANCE;
    }
}
