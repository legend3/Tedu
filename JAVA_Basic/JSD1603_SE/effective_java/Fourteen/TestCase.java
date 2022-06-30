package effective_java.Fourteen;

import org.testng.annotations.Test;

public class TestCase {
    @Test
    public void test01() {
        CaseInsensitiveString c1 = new CaseInsensitiveString("01");
        CaseInsensitiveString c2 = new CaseInsensitiveString("02");
        CaseInsensitiveString c3 = new CaseInsensitiveString("03");

        System.out.println("第一规定：" + (c1.compareTo(c2) == -(c2.compareTo(c1))));

        //第二规定
        if ((c1.compareTo(c2) < 0) && (c2.compareTo(c3) < 0)) {
            System.out.println("第二规定: " + (c1.compareTo(c3) < 0));
        }

        //第三规定
        CaseInsensitiveString c4 = new CaseInsensitiveString("c");
        CaseInsensitiveString c5 = new CaseInsensitiveString("c");
        CaseInsensitiveString c6 = new CaseInsensitiveString("cc");

        switch (c4.compareTo(c5)) {
            case 0:
                System.out.println("第三规定：" + (c4.compareTo(c6) == (c5.compareTo(c6))));
        }
    }
    @Test
    public void test02() {
        A a1 = new A("a1");
        A a2 = new A("a1");
        PhoneNumber phoneNumber01 = new PhoneNumber(707, 867, 5309, a1);
        PhoneNumber phoneNumber02 = new PhoneNumber(707, 867, 5309, a2);
        System.out.println(phoneNumber01.compareTo(phoneNumber02));
    }
}
