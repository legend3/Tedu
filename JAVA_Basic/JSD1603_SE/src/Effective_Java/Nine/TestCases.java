package Effective_Java.Nine;



import org.junit.Test;

import java.io.IOException;

public class TestCases {
    @Test
    public void test01() throws IOException {
        Case01.firstLineOfFile("Effective_Java/Nine/file.txt");
    }
    @Test
    public void test02() throws IOException {
        Case02.copy("Effective_Java/Nine/file.txt", "abc");
    }
    @Test
    public void test03() throws IOException {
        Case03.firstLineOfFile("Effective_Java/Nine/file.txt");
    }
    @Test
    public void test04() throws IOException {
        Case04.copy("Effective_Java/Nine/file.txt", "abc");
    }
    @Test
    public void test05() throws IOException {
        Case05.firstLineOfFile("Effective_Java/Nine/file.txt", "null");
    }
}
