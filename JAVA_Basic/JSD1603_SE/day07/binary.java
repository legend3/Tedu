package day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class binary {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int n=234;
		System.out.println(Integer.toString(n));
		
		int i=0xae;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(i);
		
		int max=0x7fffffff;
		System.out.println(Integer.toBinaryString(max));
		int min=0x80000000;
		System.out.println(Integer.toBinaryString(min));
		
		int m=-1;
		System.out.println(m);
		System.out.println(Integer.toBinaryString(m));
		
		int p=Integer.MAX_VALUE;
		System.out.println(Integer.toBinaryString(p));
		
		RandomAccessFile raf=new RandomAccessFile("demo.dat","rw");
		int l=213133321;
		raf.writeInt(l);//不仅写低八位
		raf.seek(0);
		int j=raf.readInt();//不仅读低八位
				raf.close();
		System.out.println(l);
		
		int yy=-20;
		int xx=~yy+1;
		System.out.println(xx);
		System.out.println(Integer.toBinaryString(xx));
		
		System.out.println();
		
		//掩码
		int nn=0x6db7b6e5;
		int mask=0xf;
		int mm=nn&mask;//1.截取  2.结果为2的整次幂的余数(nn%8(2^3),mm为余数)
		System.out.println(Integer.toBinaryString(nn));
		System.out.println("\t"+"\t"+"\t"+Integer.toBinaryString(mask));
		System.out.println("\t"+"\t"+"\t"+Integer.toBinaryString(mm));
		
		int ii=0;
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		System.out.println(ii++&0x7);
		
		//或“|”
		int pp=0x6d64c311;
		int b1=0x6d;
		int b2=0x64;
		int b3=0xc3;
		int b4=0x11;
		System.out.println();
	
		//拆分
		b1=(pp>>>24)&0xff;
		b2=(pp>>>16)&0xff;
		b3=(pp>>>8)&0xff;
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(Integer.toBinaryString(b3));
		System.out.println(Integer.toBinaryString(b4));
		System.out.println();
		
		//拼凑readInt()
		int v=(b1<<24) | (b2<<16) | (b3<<8) | b4;
		System.out.println(Integer.toBinaryString(v));
		System.out.println();
		
		String str="今天吃了吗";
		for(int i1=0;i1<str.length();i1++){
			char c=str.charAt(i1);
			System.out.println(Integer.toBinaryString(c));
		}
		System.out.println();
		
		
		//将字符串序列化为byte数据的方法
		//字符串的序列化称为：字符串编码
		//字符串的编码：方案之一是UTF-16BE(（定长）优点：直观；缺点：只能支持655365个字符；不管中英文都是两字节，在中文中会浪费一半空间)
		//UTF-8（万国码，变长( 字节可不固定(1,2,3,4字节均可))；缺点：存在标识位会占用字节，特别是中文+标识符就会成3个字节）
		//GBK（缺点：2000多中英文字符；优点：中文2byte，英文1byte(分的很清楚，中文混合适合)，中国本地话最优编码）
		byte[] buf=str.getBytes("GBK");
		for(int b:buf){
			System.out.println(Integer.toBinaryString(b&0xff));
		}
		
		//读取编码原理
		RandomAccessFile raf1=new RandomAccessFile("qwert.dat","r");
		byte[] buf1=new byte[200];
		// 从文件raf中读取多个byte填充到buf数组中，返回值表示填充个数
		int n1=raf1.read(buf1);
		System.out.println(n1);//n1为一批(一次)的字节数("今天你吃了吗"12个字节)
		//n1表示，200个字节中前n1个是有效的
		String str1=new String(buf1,0,n1,"GBK");//会默认，所以注意指定编码。
		System.out.println(str1);
		raf1.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
