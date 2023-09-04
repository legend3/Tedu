package Effective_Java.Nine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 1. 要使用这个构造，
 * 资源必须实现 AutoCloseable 接口，该接口由一个返回为 void 的 close 组成。Java 类库和第三方类库中的
 * 许多类和接口现在都实现或继承了 AutoCloseable 接口。如果你编写的类表示必须关闭的资源，那么这个类也应
 * 该实现 AutoCloseable 接口。
 *
 * 2.
 * 如果调用 readLine 和（不可见） close 方法都抛出异常，则后一个异常将被抑制
 * （suppressed），而不是前者。 事实上，为了保留你真正想看到的异常，可能会抑制多个异常。 这些抑制的异常没
 * 有被抛弃， 而是打印在堆栈跟踪中，并标注为被抑制了。 你也可以使用 getSuppressed 方法以编程方式访问它
 * 们，该方法在 Java 7 中已添加到的 Throwable 中。
 */
public class Case03 {
    // try-with-resources - the the best way to close resources!
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
        //资源继承或实现了AutoCloseable接口，会自动关闭
    }

}
