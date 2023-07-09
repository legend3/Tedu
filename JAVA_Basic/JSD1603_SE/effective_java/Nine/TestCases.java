package effective_java.Nine;



import org.junit.Test;

import java.io.IOException;

public class TestCases {
    @Test
    public void test01() throws IOException {
        Case01.firstLineOfFile("effective_java/Nine/file.txt");
    }
    @Test
    public void test02() throws IOException {
        Case02.copy("effective_java/Nine/file.txt", "abc");
    }
    @Test
    public void test03() throws IOException {
        Case03.firstLineOfFile("effective_java/Nine/file.txt");
    }
    @Test
    public void test04() throws IOException {
        Case04.copy("effective_java/Nine/file.txt", "abc");
    }
    @Test
    public void test05() throws IOException {
        Case05.firstLineOfFile("effective_java/Nine/file.txt", "null");
    }
}
