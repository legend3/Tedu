package Effective_Java.Seven;


import org.junit.Test;

public class TestCases {
    @Test
    public void test01() {
        Stack stack = new Stack();
        stack.push("1");
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}