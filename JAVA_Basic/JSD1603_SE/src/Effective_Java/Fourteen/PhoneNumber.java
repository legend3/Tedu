package Effective_Java.Fourteen;

import java.util.Comparator;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    private A a;

    public PhoneNumber(int areaCode, int prefix, int lineNumber, A a) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
        this.a = a;
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
                && pn.a.equals(a);//递归调用
    }

    private volatile int hashCode; // (See item 71)
    @Override public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);//首个field
            //剩余的filed
            result = 31 * result + Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNumber);
            result = 31 * result + a.hashCode();
            hashCode = result;//把散列码缓存在对象内部
        }
        return result;//返回结果
    }

    /**
     *
     * @param pn
     * @return
     */
    // Multiple-field Comparable with primitive fields
//    public int compareTo(PhoneNumber pn) {
//        int result = Short.compare(areaCode, pn.areaCode);//属性用包装类(实现过Comparable)
//        if (result == 0) {//是否相等，各个filed依此类推
//            result = Short.compare(prefix, pn.prefix);
//            if (result == 0)
//                result = Short.compare(lineNumber, pn.lineNumber);
//        }
//        return result;//返回+(大于)、0(相等)、-(小于)结果
//    }

    /**
     * 利用java8里给定的基本数字类型-int类型的比较器:
     *
     * comparingInt方法：接受从类型 T 中提取 int 排序键的函数，并返回按该排序键(Integer.compare(x,y))进行比较的 Comparator<T>；
     * thenComparingInt方法：将返回字典顺序比较器，并带有提取int排序键的函数。
     */
    // Comparable with comparator construction methods，在使用这种方法(Java 8 中 Comparator 接口)时，考虑使用 Java
    //的静态导入，以便可以通过其简单名称来引用比较器静态方法，以使其清晰简洁
    private static final Comparator<PhoneNumber> COMPARATOR =
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)//该比较器首先应用原始比较器(compare(c1, c2))，(pn.areaCode相等时)然后使用提取的键(再用comparingInt的比较器比较pn.prefix)来打破连接
                    .thenComparingInt(pn -> pn.lineNumber)//多次调用，(上一层相等时)再比较新的提取的键
                    .thenComparing(comparing(pn -> pn.a));//thenComparing(Comparator<? super T> other)//

    //通过Java 8 中 Comparator 接口提供了一系列比较器方法构建的比较器，实现compareTo方法(而不是实现Comparable接口的方式！)
    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }
}
