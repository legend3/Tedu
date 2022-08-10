package enumDemo.case01;

/**
 * 系统代码的枚举类型:
 *      不同对象的统一接口方法的实现！
 */
public enum CodeEnum implements SystemCode {
    //枚举项(其实每个枚举项都是一个匿名类的子类对象！)
    SUCCESSFUL(0, "操作成功！") {//0, "操作成功！"就是set()方法赋值！
        @Override
        public void getMessage(String message) {
            System.out.println("SUCCESSFUL枚举项重写getMessage抽象方法：" + message);
        }
    },
    ERROR(-1, "系统错误"){
        @Override
        public void getMessage(String message) {
            System.out.println("ERROR枚举项重写getMessage抽象方法：" + message);
        }
    },
    FAILURE(1, "操作成功！"){
        @Override
        public void getMessage(String message) {
            System.out.println("FAILURE枚举项重写getMessage抽象方法：" + message);
        }
    };

    private int code;//系统代码
    private String desc;//代码对应的描述信息

    private CodeEnum() {
    }

//枚举类的构造器不可以添加访问修饰符，枚举类的构造器默认是private的。但你自己不能添加private来修饰构造器
    CodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getDes() {
        return this.desc;
    }

    /**
     * 枚举类中还可以有抽象方法：
     * 还可以在枚举类中给出抽象方法，然后在创建每个枚举项时使用“特殊”的语法来重复抽象方法。所谓“特殊”语法就是匿名内部类！
     * 也就是说每个枚举项都是一个匿名类的子类对象！
     * 通常getMessage()方法应该定义为抽象的方法，因为每个枚举常量都会去重写它。
     * 你无法把CodeEnum声明为抽象类，但需要声明getMessage()方法为抽象方法。
     */
    public abstract void getMessage(String message);//只需要把getMessage()方法修改为抽象方法，但不可以把CodeEnum类声明为抽象类。
}
