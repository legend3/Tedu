package day07;

public class Demo01 {

	public static void main(String[] args) {
		int i = 56;
		System.out.println(i); //"56"
		
		int n = 234;
		System.out.println(Integer.toBinaryString(n));//十转二，11101010
		
		//int max = Integer.MAX_VALUE;
// 01111111 11111111 11111111 11111111
// 7   f    f   f    f   f    f   f    
		int max = 0x7fffffff;
		System.out.println(Integer.toBinaryString(max));//十六转二，1111111111111111111111111111111
		System.out.println(max);//十六自动给转十，2147483647
		int min = 0x80000000;
		System.out.println(Integer.toBinaryString(min));//10000000000000000000000000000000
		
		max = Integer.MAX_VALUE;
		
		n = 6;
		int m = (max+1)*2+n;//max+1正数溢出结果可能是负数或正数
		System.out.println(m);//6
		
		int x = -1;
		System.out.println(~x);//0
		
//x=00000000 00000101 11011000 11001000
//  11111111 11111010 00100111 00110111
//	             5    D   8    C   8 
	   x = 0x5d8c8;//383176
	   System.out.println(x);
	   System.out.println(Integer.toBinaryString(~x));//11111111111110100010011100110111
	   System.out.println(~x);//-383177,~取反
	   
	   n = 2;
// n:00000000000000000000000000000010
//~n:11111111111111111111111111111101
// -3
	   System.out.println(~n);//-3
	   System.out.println(~n+1);//-2,反码=原码取反 + 1
//-2:11111111111111111111111111111110
	   
	   n = -20;
	   System.out.println(~n);//19
	   System.out.println(~n+1);//20
	}
}





