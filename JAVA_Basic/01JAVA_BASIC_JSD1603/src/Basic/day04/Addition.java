package Basic.day04;
import java.util.Scanner;
//随机加法运算器
public class Addition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int score=0; //得分
		for(int i=1;i<=1;i++){ //10次
			int a = (int)(Math.random()*100); //加数a
			int b = (int)(Math.random()*100); //加数b
			int result = a+b; //记录结果
			System.out.println("("+i+")"+a+"+"+b+"=?"); //1.出题

			System.out.println("算吧!");
			int answer = scan.nextInt(); //2.答题

			if(answer==result){ //3.判题
				score+=10; //答对一题加10分
				System.out.println("答对了");
			}else{
				System.out.println("答错了");
			}
		}
		System.out.println("得分为:"+score);

		//Math: 类包含用于执行基本数学运算的方法(JAVA的内置高级计算器)
		System.out.println("Math.sqrt()平方: " + Math.sqrt(2));//开方
		System.out.println("Math.max()比较最大值: " + Math.max(2,6));//比较最大值
		System.out.println("Math.abs()绝对值: " + Math.abs(-3));//绝对值
		System.out.println("Math.round()四舍五入: " + Math.round(3.44325325432f));//四舍五入
		System.out.println(Math.round(3.54325325432f));//四舍五入
	}
}