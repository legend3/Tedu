package Basic.day06;
import java.util.Scanner;
//猜字符游戏
public class Guessing {
	//主方法
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate(); //获取随机字符数组
//		System.out.println(chs); //作弊
		int count = 0; //猜错的次数
		while(true){ //自造死循环
			System.out.println("猜吧!");
			String str = scan.next().toUpperCase(); //接收用户输入的字符串，将转换为大写字母
			if(str.equals("EXIT")){ //判断str的值是否是EXIT
				System.out.println("下次再来吧!");
				break;
			}
			char[] input = str.toCharArray(); //将字符串转为字符数组
			int[] result = check(chs,input); //对比:随机字符数组与用户输入的字符数组
			if(result[0]==chs.length){ //猜对了
				int score = 100*chs.length-10*count; //1个字符100分，猜错一次扣10分
				System.out.println("恭喜你猜对了，得分为:"+score);
				break; //终止循环
			}else{ //猜错了
				count++; //猜错次数增1
				System.out.println("字符对个数:"+result[1]+"，位置对个数:"+result[0]);
			}
		}
		
	}
	
	//随机生成字符数组
	public static char[] generate(){
		char[] chs = new char[5]; //随机字符数组
		
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' }; //随机字符范围--26个大写字母
		boolean[] flags = new boolean[letters.length]; //开关数组，默认值为false，表示未存过
		for(int i=0;i<chs.length;i++){ //遍历随机字符数组
			int index; //下标
			do{
				index = (int)(Math.random()*letters.length); //生成随机的下标
			}while(flags[index]==true); //当下标对应的开头为true时，表示已存过，则重新生成index下标
			                            //当下标对应的开头为false时，表示未存过，则循环结束
			chs[i] = letters[index]; //基于下标index来获取letters中的字符，再赋值给chs中的每一个元素
			flags[index] = true; //将下标对应的开头修改为true，表示已存过
		}
		
		return chs;
	}
	
	//对比:随机字符数组与用户输入的字符数组
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2]; // 对比结果(0,0)，假设result[1]为字符对个数，result[0]为位置对个数
		for(int i=0;i<chs.length;i++){ // 遍历随机字符数组
			for(int j=0;j<input.length;j++){ //遍历用户输入的字符数组
				if(chs[i]==input[j]){ //字符对
					result[1]++; //字符对个数增1
					if(i==j){ //位置对
						result[0]++; //位置对个数增1
					}
					break; //input中剩余元素不再比较
				}
			}
		}
		return result;
	}
}
