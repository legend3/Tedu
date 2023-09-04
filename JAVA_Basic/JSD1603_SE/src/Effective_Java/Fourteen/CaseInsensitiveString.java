package Effective_Java.Fourteen;


/**
 * 不同于equal方法对比，equals 方法在所有对象上施加了全局等价关系， compareTo 不必跨越不同类型的对象
 *
 * CaseInsensitiveString 类实现了 Comparable<CaseInsensitiveString> 接口。这意味着
 * CaseInsensitiveString 引用只能与另一个 CaseInsensitiveString 引用进行比较
 *
 * 缺点：具有耦合性，不好维护！
 */
// Single-field Comparable with object reference field
public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    private String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);//按compareToIgnoreCase排序String对象的Comparator。这个比较器是可序列化的
    }


//...  Remainder omitted
}

