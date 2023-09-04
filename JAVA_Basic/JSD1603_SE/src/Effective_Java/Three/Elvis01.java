package Effective_Java.Three;

/**
 * 第一种方式：公共属性方法
 */
public class Elvis01 {
    public static final Elvis01 INSTANCE = new Elvis01();

    private Elvis01() {//无法new
    }

    public void leaveTheBuilding() {

    }
}
