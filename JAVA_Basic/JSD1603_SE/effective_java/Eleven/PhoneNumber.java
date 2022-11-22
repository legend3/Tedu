package effective_java.Eleven;

import java.util.Arrays;

public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    private mobile m;
    private mobile[] mobiles;
    private String[] s;

    public PhoneNumber(int areaCode, int prefix, int lineNumber, mobile m, String[] s) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        rangeCheck(m.getMobile(), 999, "mobilenumber");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
        this.m = m;
        this.mobiles = new mobile[]{m, new small(100)};//数组中有m重要field;
        this.s = s;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }

    @Override public boolean equals(Object o) {
        if (o == this)//是否同地址
            return true;
        if (!(o instanceof PhoneNumber))//是否本类的实例(包括子类实例)
            return false;
        PhoneNumber pn = (PhoneNumber)o;//强转为本类
//        System.out.println(System.identityHashCode(pn.mobiles[1]));
//        System.out.println(System.identityHashCode(mobiles[1]));
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode
                && pn.m.equals(m)//递归引用域的equal方法
                && Arrays.equals(pn.mobiles, mobiles)
                && Arrays.equals(pn.s, s);
    }

    private volatile int hashCode; // (See item 71)
    @Override public int hashCode() {//定义对象的大小
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);//首个field
            //剩余的filed
//            result = 31 * result + Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNumber);
            result = 31 * result + m.hashCode();//递归调用引用域(mobile)的hashcode方法
            result = 31 * result + m.hashCode();//递归调用引用域(mobile)的hashcode方法,用于mobiles数组
            result = 31 * result + Arrays.hashCode(s);//数组全是重要元素
            hashCode = result;//把散列码缓存在对象内部
        }
        return result;//返回结果
    }

    /*把散列码缓存在对象内部*/
//    private volatile int hashCode; // (See item 71)
//    @Override public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = 17;
//            result = 31 * result + areaCode;
//            result = 31 * result + prefix;
//            result = 31 * result + lineNumber;
//            hashCode = result;//缓存在对象内部
//        }
//        return result;
//    }

}
