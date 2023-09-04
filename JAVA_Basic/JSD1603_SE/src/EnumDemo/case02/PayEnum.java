package EnumDemo.case02;

/**
 * 一个类定义多种实例形式
 */
public enum PayEnum {//每个枚举类型继承java.lang.Enum,所以枚举类不能再继承其他类型
    //枚举项，采用全部大写名命
    //枚举项就是一个一个对象，他是常量，可定义枚举项的时候调用构造方法(当前调用的时候有参构造方法)
    /*
        注意事项：枚举本质时被编译器处理成类，枚举值是静态的常量属性，枚举只是一种语法糖，被编译器生成最终的类。当用set方法进行赋值(枚举构造方法值)的时候，
                    实际上是修改的一个内存中的静态变量的值，这个值原本的意义就被修改了.
        结论：枚举构造方法赋值不能用set方法赋值
     */
    WEIXINPAY("weixin", "https://weixin.com"),//"weixin", "https://weixin.com"就是set方法赋值
    ALIPAY("ali", "https://ali.com"),
    UNIONPAY("union", "https://union.com");

    //枚举类的属性
    private String name;
    private String payUrl;

    //枚举类型的构造方法(默认)使用private
    PayEnum(String name, String payUrl) {
        this.name = name;
        this.payUrl = payUrl;
    }

    public String getName() {
        return name;
    }

    public String getPayUrl() {
        return payUrl;
    }
}
