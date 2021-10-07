package enumDemo.case02;

public enum PayEnum {//每个枚举类型继承java.lang.Enum,所以枚举类不能再继承其他类型
    //枚举项，采用全部大写名命
    //枚举项就是一个一个对象，他是常量，可定义枚举项的时候调用构造方法(当前调用的时候有参构造方法)
    WEIXINPAY("weixin", "https://weixin.com"),
    ALIPAY("ali", "https://ali.com"),
    UNIONPAY("union", "https://union.com");

    //枚举类的属性
    private String name;
    private String payUrl;

    //枚举类型的构造方法使用private
    PayEnum(String name, String payUrl) {
        this.name = name;
        this.payUrl = payUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }
}
