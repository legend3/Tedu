package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 1.
 * RandomAccessFile，该类是IO流体系中功能最丰富的文件内容访问类，既可以读取文件内容，也可以向文件输出数据。
 * RandomAccessFile既可以读取文件内容，也可以向文件输出数据。同时，RandomAccessFile支持“随机访问”的方式，程序快可以直接跳转到文件的任意地方来读写数据。
 * 由于RandomAccessFile可以自由访问文件的任意位置，所以如果需要访问文件的部分内容，而不是把文件从头读到尾，使用RandomAccessFile将是更好的选择。
 * 与OutputStream、Writer等输出流不同的是，RandomAccessFile允许自由定义文件记录指针，RandomAccessFile可以不从开始的地方开始输出，因此RandomAccessFile可以向已存在的文件后追加内容。如果程序需要向已存在的文件后追加内容，则应该使用RandomAccessFile。
 * RandomAccessFile的方法虽然多，但它有一个最大的局限，就是只能读写文件，不能读写其他IO节点。
 * RandomAccessFile的一个重要使用场景就是网络请求中的多线程下载及断点续传。
 *
 * 基于指针形式读写文件数据。
 *2.
 * RandomAccessFile类有两个构造函数，其实这两个构造函数基本相同，只不过是指定文件的形式不同——一个需要使用String参数来指定文件名，一个使用File参数来指定文件本身。除此之外，创建RandomAccessFile对象时还需要指定一个mode参数，该参数指定RandomAccessFile的访问模式，一共有4种模式。
 * **"r" : ** 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
 * "rw": 打开以便读取和写入。
 * "rws": 打开以便读取和写入。相对于 "rw"，"rws" 还要求对“文件的内容”或“元数据”的每个更新都同步写入到基础存储设备。
 * "rwd" : 打开以便读取和写入，相对于 "rw"，"rwd" 还要求对“文件的内容”的每个更新都同步写入到基础存储设备。
 *
 *3.
 * RandomAccessFile既可以读文件，也可以写文件，所以类似于InputStream的read()方法，以及类似于OutputStream的write()方法，RandomAccessFile都具备。除此之外，RandomAccessFile具备两个特有的方法，来支持其随机访问的特性。
 *
 * RandomAccessFile对象包含了一个记录指针，用以标识当前读写处的位置，当程序新创建一个RandomAccessFile对象时，该对象的文件指针记录位于文件头（也就是0处），当读/写了n个字节后，文件记录指针将会后移n个字节。除此之外，RandomAccessFile还可以自由移动该记录指针。下面就是RandomAccessFile具有的两个特殊方法，来操作记录指针，实现随机访问：
 *
 * long getFilePointer( )：返回文件记录指针的当前位置
 * void seek(long pos )：将文件指针定位到pos位置
 *
 *4.
 *
 *
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * RandomAccessFile支持两种创建模式
		 * 只读模式:仅对文件数据进行读取工作
		 * 读写模式:对文件数据读写操作
		 * 
		 * 常用构造方法
		 * RandomAccessFile(File file,String mode)
		 * 
		 * RandomAccessFile(String path,String mode)
		 * 
		 * 其中mode对应的字符串为:
		 * r:只读模式    rw:读写模式
		 */
		RandomAccessFile raf
			= new RandomAccessFile(
                "raf.dat","rw"
			);
		/*
		 * void write(int d)
		 * 写出一个字节，写的是给定的int值
		 * 所对应的2进制的"低八位"
		 *                            vvvvvvvv
		 * 00000000 00000000 00000000 00000001
		 */
		raf.write(1);
		
		System.out.println("写入完毕!");
		//读写全部进行完毕后必须关闭释放资源
		raf.close();
		
		
		
	}
}



