package effective_java.Three;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 实现一个单例的第三种方法是声明单一元素的枚举类：
 * ——枚举单例
 *
 */
public enum Elvis03 {
    INSTANCE(0, "单一元素的枚举类");

    private int i;
    private String s;

    Elvis03(int i, String s) {
        this.i = i;
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Elvis03{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }

    public void leaveTheBuilding() {

    }
}
