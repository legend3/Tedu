package Effective_Java.Nine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Case01 {
    static String firstLineOfFile(String path) throws IOException {//throws把异常抛给上层的调用者
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }
}
