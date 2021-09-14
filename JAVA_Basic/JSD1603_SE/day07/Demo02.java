package day07;

public class Demo02 {

	public static void main(String[] args) {
		//n= 11111111 11111111 11110111 11110100 
		int n = 0xfffff7f4;
		int m1 = n>>>1;
		//m1:011111111 11111111 11110111 1111010
		int m2 = n>>1;
		//m2:111111111 11111111 11110111 1111010
		System.out.println(n);
		System.out.println(m1);
		System.out.println(m2);
	}
}


