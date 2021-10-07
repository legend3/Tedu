import enumDemo.case01.CodeEnum;
import enumDemo.case01.SystemCode;
import org.testng.annotations.Test;

public class testEnum {
    @Test
    public void CodeEnum(){
        System.out.println(CodeEnum.ERROR.getCode());
        System.out.println(CodeEnum.SUCCESSFUL.getCode());

        //枚举项可以向上转型为接口类型
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
        System.out.println(CodeEnum.valueOf("SUCCESSFUL"));//指定枚举项的字符串，返回枚举项常量

        //调用抽象方法
        CodeEnum.SUCCESSFUL.("提示语");
    }

}
