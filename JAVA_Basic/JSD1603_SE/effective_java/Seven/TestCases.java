package effective_java.Seven;

import org.testng.annotations.Test;

public class TestCases {
    @Test
    public void test01() {
        Stack stack = new Stack();
        stack.push("1");
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}