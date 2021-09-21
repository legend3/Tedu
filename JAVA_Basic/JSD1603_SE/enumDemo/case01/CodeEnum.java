package enumDemo.case01;

/**
 * 系统代码的枚举类型：
 *      不同对象的统一接口方法的实现！
 */
public enum CodeEnum implements SystemCode{
    //枚举项
    SUCCESSFUL(0, "操作成功！"),
    ERROR(-1, "系统错误"),
    FAILURE(1, "操作成功！");

    private CodeEnum() {
    }

    private CodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;//系统代码
    private String desc;//代码对应的描述信息

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getDes() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CodeEnum.ERROR);
    }
}
