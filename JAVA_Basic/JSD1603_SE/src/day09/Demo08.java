package day09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo08 {

	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		/*
		 * 使用try ... catch处理可能发生的异常
		 * 如果没有异常发生，程序正常执行，如果
		 * 出现异常，就"跳"到catch处继续执行,
		 * 出现异常位置开始到以后的代码库不执行了
		 */
		while(true){
			System.out.print("输入整数:");
			try{
				int n=in.nextInt();//A
				System.out.println(n);
				break;
			}catch(InputMismatchException e){
				System.out.println("输入错了!");
				in.nextLine();
				continue;
			}
		}
	}
}
