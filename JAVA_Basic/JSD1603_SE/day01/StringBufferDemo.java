package day01;

/**
 * CLassName: day01/StringBufferDemo
 * Description:
 * StringBuffer 与 StringBuilder
 *   在 Java1.4 之前，StringBuffer 是字符串操作的唯一选择。但是它的一个缺点是所有公共方法都是同步的，StringBuffer 提供线程安全性，但以性能为代价；
 *   Java1.5 引入了一个新类 StringBuilder，除了线程安全和同步之外，它与 StringBuffer 类似；
 *
 *   StringBuffer与StringBuilder的区别：
 *      假设在单线程环境中或无关线程安全，要使用 StringBuilder ，因为 StringBuilder 运行速度最快。
 *      反之，使用 StringBuffer 进行线程安全的操作；
 *   二者与String类的区别：
 *      StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象；
 *
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/7/9 20:47
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/7/9 20:47      LEGEND        1.0         1.0 Version
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        String str = "Hello";
        StringBuffer sbf = new StringBuffer(str);  // String 转换成 StringBuffer
        StringBuilder sbd = new StringBuilder(str); // String 转换成 StringBuilder

        str = sbf.toString();  // StringBuffer 转换成 String
        str = sbd.toString();  // StringBuilder 转换成 String

        // StringBuffer 转换成 StringBuilder
        StringBuilder bufferToBuilder = new StringBuilder(sbf.toString());
        // StringBuilder 转换成 StringBuffer
        StringBuffer builderToBuffer = new StringBuffer(sbd.toString());
    }
    /**
     * StringBuffer 每次获取 toString 都会直接使用缓存区的 toStringCache 值来构造一个字符串
     * StringBuilder 则每次都需要复制一次字符数组，再构造一个字符串
     * StringBuffer 是线程安全的，它的所有公开方法都是同步的，StringBuilder 没有对方法加锁同步，所以StringBuilder 的性能要远大于 StringBuffer
    */
}
