package day07;

public class Demo02 {

	public static void main(String[] args) {
		/*正数*/
		//x = 01100100
		int x = 50;
		//y = 01100100
		int y = x >>> 1;
		//u = 01100100
		int u = x >> 1;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		System.out.println(Integer.toBinaryString(u));
		/*负数*/
		//n = 11111111 11111111 11110111 11110100
		int n = -3;//0xfffff7f4
		int m1 = n>>>1;//-3/2=-1
		//m1:011111111 11111111 11110111 1111010
		int m2 = n>>1;//-3/2=-1
		//m2:111111111 11111111 11110111 1111010
		System.out.println(n);//原码, 11111111 11111111 11110111 11110100
		System.out.println(Integer.toBinaryString(m1));//无符号右移, 01111111 11111111 11111011 11111010
		System.out.println(m2);//右移, 11111111 11111111 11111011 11111010

	}
}
