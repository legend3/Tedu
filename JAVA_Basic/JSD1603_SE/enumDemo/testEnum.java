package enumDemo;

import enumDemo.case01.CodeEnum;
import enumDemo.case01.SystemCode;
import enumDemo.case02.PayEnum;
import enumDemo.case02.PbPayFactory;
import org.testng.annotations.Test;

public class testEnum {
    @Test
    public void CodeEnumTest(){
        System.out.println(CodeEnum.ERROR.getCode());
        System.out.println(CodeEnum.SUCCESSFUL.getCode());

        //枚举项可以向上造型为接口类型
        SystemCode code = CodeEnum.SUCCESSFUL;
        System.out.println(code.getCode());
        System.out.println(code.getDes());

        //调动特殊方法
        //枚举类.values()返回一个装有所有枚举项的数据
        CodeEnum[] cs = CodeEnum.values();
        for(CodeEnum c: cs){//或CodeEnum.values()
            System.out.println("枚举项：" + c);
        }
        System.out.println("通过下标获取：" + cs[1]);//可以通过下标找到枚举项
        System.out.println("SUCCESSFUL的下标：" + CodeEnum.SUCCESSFUL.ordinal());//返回SUCCESSFUL枚举项的下标
        //枚举类.valueOf()通过枚举常量的名字返回Direction常量，注意，这个方法与Enum类中的valueOf()方法的参数个数不同
        System.out.println(CodeEnum.valueOf("SUCCESSFUL"));//把字符串转换成枚举常量

        //调用抽象方法
        CodeEnum.SUCCESSFUL.getMessage("提示语");
        CodeEnum.ERROR.getMessage("提示语");
        CodeEnum.FAILURE.getMessage("提示语");

        //其他API
        System.out.println(CodeEnum.SUCCESSFUL.toString());//把枚举常量转换成字符串
        System.out.println(CodeEnum.FAILURE.name());//返回枚举常量的名字
        System.out.println(CodeEnum.ERROR.name());
    }
    @Test
    public void PayEnumTest() {
        PayEnum weixinPay = PayEnum.WEIXINPAY;//枚举项就是一个对象
        System.out.println(PayEnum.WEIXINPAY.getName());
        System.out.println(PayEnum.WEIXINPAY.getPayUrl());

        //枚举项之间如何比较呢？
        PayEnum aliPay = PayEnum.ALIPAY;
        System.out.println(aliPay == PayEnum.ALIPAY);
    }
    @Test
    public void PbPayFactoryTest() {
        /*
            验证switch支持枚举项
         */
        PbPayFactory.getPay(PayEnum.WEIXINPAY);
        PbPayFactory.getPay(PayEnum.ALIPAY);
    }
}
