package Basic.day03;
//分支结构的演示
public class IfDemo {
	public static void main(String[] args) {
		int num = 4;//default
		switch(num){ //char, byte, short, int, Character, Byte, Short, Integer, String, or an enum
		case 1:
			System.out.println(111);
			break;
		case 2: //以此为入口
			System.out.println(222);
			break; //跳出switch
		case 3:
			System.out.println(333);
			break;
		default: //所有case都不匹配时执行
			System.out.println(666);
		}

		String str = "柚子";
		switch (str){
			case "柚子":
				System.out.println("这个是柚子!");
				break;
			case "西瓜":
				System.out.println("这个是西瓜!");
				break;
			case "黄瓜":
				System.out.println("这个是黄瓜!");
			default:
				System.out.println("蔬菜水果");
		}

		/*
		int num = 5;
		if(num%2==0){
			System.out.println(num+"是偶数");
		}
		System.out.println("over");
		*/
	}
}















