package Basic.day04;
//作业讲解
public class Homework {
	public static void main(String[] args) {
		/*
		//6.根据年份和月份，计算相应的天数
		int year = 2001; //年
		int month = 8; //月
		int days = 0; //天数
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if(year%4==0 && year%100!=0 || year%400==0){
				days = 29;
			}else{
				days = 28;
			}
		}
		System.out.println("days="+days);
		*/
		
		/*
		//5.个人所得税
		double salary = 10000; //工资
		double taxSalary = salary-3500; //纳税工资
		double tax = 0.0; //税额
		if(taxSalary<=0){
			tax = 0.0; //不交税
		}else if(taxSalary<=1500){
			tax = taxSalary*0.03-0;
		}else if(taxSalary<=4500){
			tax = taxSalary*0.1-105;
		}else if(taxSalary<=9000){
			tax = taxSalary*0.2-555;
		}else if(taxSalary<=35000){
			tax = taxSalary*0.25-1005;
		}
		System.out.println("tax="+tax);
		*/
		
		/*
		//4.闰年的判断
		int year = 2001;
		if(year%4==0 && year%100!=0 || year%400==0){
			System.out.println(year+"是闰年");
		}else{
			System.out.println(year+"不是闰年");
		}
		*/
		
		/*
		 * 补充:
		 * 1.变量的作用域:
		 *    从变量的声明开始，到包含它最近的大括号结束
		 * 2.变量的重名问题:
		 *    作用域重叠时，变量不能同名
		 */
		/*
		int a=5;
		if(a>2){
			int b=8;
			//int a=55; //编译错误，作用域重叠时，不能同名
		}else{
			int b=88;
		}
		*/
		
		/*
		int a=5;
		if(a>2){
			int b=8;
			System.out.println(a);
			System.out.println(b);
		}
		System.out.println(a);
		//System.out.println(b); //编译错误，b超范围了
		*/
		
		/*
		//3.三个数排序
		int a=10,b=8,c=5;
		if(a>b){
			int t=a;
			a=b;
			b=t; 
		}
		if(a>c){
			int t=a;
			a=c;
			c=t;
		}
		if(b>c){
			int t=b;
			b=c;
			c=t;
		}
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		*/
		
		
		
		
		
		
		
		/*
		//2.两个数排序
		int a=8,b=55;
		if(a>b){ //若a>b则换，保证a<b
			int t=a;
			a=b;
			b=t;
		}
		System.out.println("a="+a);
		System.out.println("b="+b);
		*/
		
		
		/*
		//1.求两个数的最大值
		int a=5,b=8;
		int max=a>b?a:b;
		System.out.println("max="+max);
		*/
	}
}










