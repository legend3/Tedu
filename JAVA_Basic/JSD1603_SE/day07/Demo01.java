package day07;

public class Demo01 {

	public static void main(String[] args) {
		int i = 56;
		System.out.println(i); //"56"
		
		int n = 234;
		System.out.println(Integer.toBinaryString(n));
		
		//int max = Integer.MAX_VALUE;
// 01111111 11111111 11111111 11111111
// 7   f    f   f    f   f    f   f    
		int max = 0x7fffffff;
		System.out.println(Integer.toBinaryString(max));
		System.out.println(max);
		int min = 0x80000000;
		System.out.println(Integer.toBinaryString(min));
		
		max = Integer.MAX_VALUE;
		
		n = 6;
		int m = (max+1)*2+n;
		System.out.println(m); //6
		
		int x = -1;
		System.out.println(~x);//0
		
//x=00000000 00000101 11011000 11001000
//  11111111 11111010 00100111 00110111
//	             5    D   8    C   8 
	   x = 0x5d8c8;//9
	   System.out.println(x);
	   System.out.println(Integer.toBinaryString(~x));
	   System.out.println(~x); 
	   
	   n = 2;
// n:00000000000000000000000000000010
//~n:11111111111111111111111111111101
// -3
	   System.out.println(~n);//-3
	   System.out.println(~n+1);//-2
//-2:11111111111111111111111111111110
	   
	   n = -20;
	   System.out.println(~n);//19
	   System.out.println(~n+1);//20
	   
	  
	}
}





