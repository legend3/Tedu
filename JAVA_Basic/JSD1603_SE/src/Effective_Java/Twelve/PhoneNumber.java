package Effective_Java.Twelve;

public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    private volatile int hashCode; // (See item 71)
    @Override public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
            hashCode = result;
        }
        return result;
    }

    public static PhoneNumber valueOf(String type) {
        PhoneNumber phoneNumber;
        switch (type) {
            case "S":
                phoneNumber = new SmallTelephone();
                break;
            case "L":
                phoneNumber = new LandlinePhone();
                break;
            default:
                phoneNumber = null;
        }
        return phoneNumber;
    }
    /*
        指定格式的好处是它可以作为标准的，明确的，可读的对象表示。 这种表示形式可以用于输入、输出以及持久化可读性的数据对象，如 CSV 文件
        如果指定了格式，通常提供一个匹配的静态工厂或构造方法，是个好主意，所以程序员可以轻松地*在对象和字符串表示之间来回转换
    */

    public String toString() {//多个toString()方法，依靠静态工厂方法调用
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNumber);
    }

    public String toString(String s) {//多个toString()方法，依靠静态工厂方法调用
        return "PhoneNumber{" +
                "areaCode=" + areaCode +
                ", prefix=" + prefix +
                ", lineNumber=" + lineNumber +
                ", hashCode=" + hashCode +
                ", s=" + s +
                '}';
    }
}
