package effective_java.Nine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 可以在 try-with-resources 语句中添加 catch 子句，就像在常规的 try-finally 语句中一样。这允许你处理异常，而
 * 不会在另一层嵌套中污染代码。作为一个稍微有些做作的例子，这里有一个版本的 firstLineOfFile 方法，它不
 * 会抛出异常，但是如果它不能打开或读取文件，则返回默认值
 */
public class Case05 {
    // try-with-resources with a catch clause
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();//finally之前的第一个异常
        } catch (IOException e) {//readLine前的第一个异常
            return defaultVal;
        }//依次承接，
        // 前一个异常会抑制后面的多个异常，这些抑制的异常没有被抛弃， 而是打印在堆栈跟踪中，并标注为被抑制了。
        // 你也可以使用 getSuppressed 方法以编程方式访问它们，该方法在 Java 7 中已添加到的 Throwable 中。
//        throw new IOException("XXX");
//        e.printStackTrace();
//        e.getMessage();
//        e.toString();
//          ....
    }

}
