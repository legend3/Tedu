package effective_java.Twelve;

import org.testng.annotations.Test;

public class TestCases {
    @Test
    public void test01() {
        PhoneNumber phoneNumber = new PhoneNumber(010, 0571, 998);
        System.out.println(phoneNumber);
    }
    @Test
    public void test02() {
        System.out.println(PhoneNumber.valueOf("S").toString());
        System.out.println(PhoneNumber.valueOf("L").toString("cao!"));
    }
}
