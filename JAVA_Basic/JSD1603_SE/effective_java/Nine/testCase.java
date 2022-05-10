package effective_java.Nine;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class testCase {
    @Test
    public void test01() {
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");//第一个实例，被放入map中
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));//第二个实例，被用于获取
        /*
            由于 PhoneNumber 类没有覆盖 hashCode 方法，从而导致两个相等的实例具有不相等的散列码;
            因此， put 方法把电话号码对象存放在一个散列桶（hash bucket, 又称，散列数组）中， get 方法却在另一个散列桶中查找这个电话号码
         */
        int i = 6;
        System.out.println(31 * i);
        System.out.println(Integer.toBinaryString(i));//0110
        System.out.println(Integer.toBinaryString(i<<5));//1100 0000
        System.out.println(0xc0);//1100 0000
        System.out.println( 31 * i == (i << 5) - i);//31有个很好的特性，即用位移和减法来代替乘法，可以得到更好的性能， 31 * i == (i << 5) - i 。现代的VM可以自动完成这种优化
    }
}
