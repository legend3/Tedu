package day03.work;

import java.util.Scanner;

/**
 * 要求在控制台输入一个计算表达式:
 * 例如:
 * 1+2  
 * 3
 * 
 * a+1
 * 不是数学计算表达式
 * 
 * 1+2*3+(3+4)=
 *
 * 3*5+1/2
 * @author Administrator
 *
 */
public class Work01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个计算表达式:");
		String line = scanner.nextLine();
		//操作符的位置
		int index = 0;
		if((index = line.indexOf("+"))>0){
			print(index,line,1);
		}else if((index = line.indexOf("-"))>0){
			print(index,line,2);
		}else if((index = line.indexOf("*"))>0){
			print(index,line,3);
		}else if((index = line.indexOf("/"))>0){
			print(index,line,4);
		}
	}
	/**
	 * 
	 * @param index
	 * @param type 1加 2减 3乘 4除
	 */
	public static void print(int index,String line,int type){
			int a= 
				Integer.parseInt(
					line.substring(0,index)
				);
			int b 
				=
				Integer.parseInt(
					line.substring(index+1)	
				);
			if(type==1){
				System.out.println(a+"+"+b+"="+(a+b));
			}else if(type==2){
				System.out.println(a+"-"+b+"="+(a-b));
			}else if(type==3){
				System.out.println(a+"*"+b+"="+(a*b));
			}else if(type==4){
				System.out.println(a+"/"+b+"="+(a/b));
			}
			
	}
}







