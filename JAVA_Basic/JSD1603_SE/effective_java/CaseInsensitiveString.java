package effective_java;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


/**
 * 第8条：覆盖 equals 时请遵守通用约定
 *
 * 自反性
 * 对称性
 */

public class CaseInsensitiveString {
    private String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }
//    @Override
//    public boolean equals(Object o) {//test01
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(//如果两个字符串的长度相同，并且两个字符串中的对应字符相等，忽略大小写，则认为两个字符串相等。
//                    ((CaseInsensitiveString) o).s);
//        }
//            if (o instanceof String) { // One-way interoperability!
//                return s.equalsIgnoreCase((String) o);
//            }
//            return false;
//        }

    //为了解决(对称性)这个问题，只需把企图与 String 互操作的这段代码从 equals 方法中去掉就可以了
    @Override public boolean equals(Object o) {//test02
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    @Test
    public void test01(){
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("polish");
        String s = "polish";
        System.out.println(cis.equals(cis2));
        System.out.println(cis.s.equals(s));

        System.out.println(s.equals(cis.s) + ": 违反了对称性");
        List<String> list = new ArrayList<String>();
        list.add(cis.s);
        System.out.println(list.contains(s) + ": 违反了自反性");
    }

    @Test
    public void test02(){
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("polish");
        String s = "polish";
        System.out.println(cis.equals(cis2));
        System.out.println(cis2.equals(cis));
    }
}
