package effective_java.One;

public class BooleanDemo {
    /*
    * 同时拥有构造方法与静态工厂方法(弥补静态工厂方法的缺点)
    * */
    public BooleanDemo() {

    }

    /*
       静态工厂方法替代构造方法创建实例
    */
    public static Boolean getBoolean(boolean b) {//好处1.(BooleanDemo其实就是演示Boolean类的例子)
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Boolean getBoolean2(boolean b) {//好处2.
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static BooleanDemo getBoolean3() {//好处3.
        return new X();//X是BooleanDemo子类
    }

    public static BooleanDemo getBoolean4(String type) {//好处4.(多个子类时)
        BooleanDemo booleanDemo;
        switch (type) {
            case "X":
                booleanDemo = new X();
                break;
            default:
                booleanDemo = null;
                break;
        }
        return booleanDemo;
    }

    /*好处5.在编写包含该方法的类时，返回的对象的类不需要存在*/
    public static A getBoolean5(A a) {//A是接口必然返回的是A的实现类，但是编写时即便A的实现类B不存在也不影响静态工厂方法的编写(不会报错，要用时才报错.)
        return a;
    }

    @Override
    public String toString() {
        return "BooleanDemo{}";
    }
}
