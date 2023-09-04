package EnumDemo;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

public class CharsetDemo {
    public static void main(String[] args) {

// 获取Java支持的全部字符集
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String alias : map.keySet()) {
            // 输出字符集的别名
            System.out.println(alias);
        }
        // 创建简体中文对应的Charset
        Charset charset = Charset.forName("GBK");
// 获取charset对象对应的编码器
        CharsetEncoder charsetEncoder = charset.newEncoder();
// 创建一个CharBuffer对象
        CharBuffer charBuffer = CharBuffer.allocate(20);
        charBuffer.put("CSDN-专业IT技术社区");
        charBuffer.flip();
// 将CharBuffer中的字符序列转换成字节序列
        ByteBuffer byteBuffer = null;
        try {
            byteBuffer = charsetEncoder.encode(charBuffer);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
// 循环访问ByteBuffer中的每个字节
        for (int i = 0; i < byteBuffer.limit(); i++)
        {
            System.out.print(byteBuffer.get(i) + " ");
        }
        // 创建简体中文对应的Charset
        Charset charset02 = Charset.forName("GBK");
// 获取charset对象对应的编码器
        CharsetDecoder charsetDecoder = charset.newDecoder();
// 创建一个ByteBuffer对象
        ByteBuffer byteBuffer02 = ByteBuffer.allocate(50);
        try {
            byteBuffer.put("CSDN-专业IT技术社区".getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byteBuffer.flip();

// 将ByteBuffer的数据解码成字符序列
        try {
            System.out.println(charsetDecoder.decode(byteBuffer));
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }
}
