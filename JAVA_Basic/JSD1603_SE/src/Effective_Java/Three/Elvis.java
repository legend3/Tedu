package Effective_Java.Three;

import java.io.Serializable;

public class Elvis implements Serializable {
    private static final long serialVersionUID = -43858545680L;

    /*
        防止序列化实例被反序列化时，会创建一个新的实例
     */
    //1.transient标识
    private transient static final Elvis INSTANCE = new Elvis();

    //2.readResolve方法作用：保存单例的属性
    private Object readResolve() {
        // 返回一个唯一的Elvis实例，被垃圾回收器收集
        // 保护Elvis被单例创建
        return INSTANCE;
    }
}
