package Basic.day02;

//数据类型的演示
public class DataTypeDemo {
	public static void main(String[] args) {
		/**
		 * byte类型[-127~128],一个字节,最小的整数
		 * Java中的byte，short，char进行计算时都会提升为int类型
		 */
		byte b = 127;
        System.out.println(b);
        b += 1;
        System.out.println("溢出:" + b);
        byte b1 = 1;
        byte b2  = 2;
        byte b3 = (byte) (b1 + b2); //java中进行计算时候将他们提升为int类型，再进行计算,得出int结果再赋值给byte需要强转
		System.out.println(b3);//Java中的byte，short，char进行计算时都会提升为int类型

		/*
		 * boolean、char的练习:
		 * 1.声明布尔型变量b1并赋值为true
		 *   声明布尔型变量b2并赋值为false
		 *   声明布尔型变量b3并赋值为250------???
		 * 2.声明字符型变量c1并赋值为字符男
		 *   声明字符型变量c2并赋值为字符m
		 *   声明字符型变量c3并赋值为空格符
		 *   声明字符型变量c4并赋值为中国------???
		 *   声明字符型变量c5并赋值为97，输出c5的值
		 *   声明字符型变量c6并赋值为字符\，输出c6的值
		 *   输出2+2的结果，输出'2'+'2'的结果
		 *   
		 */
		

		System.out.println('2'); //字符2
		System.out.println('2'+'2'); //数字100

		
		//5.char:字符型，2个字节
		char c1 = '女';//字符直接量必须放在单引号中
        System.out.println(c1);
		char c2 = 'f';
        System.out.println(c2);
		char c3 = '5';
        System.out.println(c3);
		char c4 = ' ';
        System.out.println(c4);//空
		//char c5 = ''; //编译错误，必须有字符
		//char c6 = '女性'; //编译错误，只能有一个字符
		//char c7 = 女; //编译错误，必须放在单引号中

		char c8 = 65;
		System.out.println(c8); //A
//
//		System.out.println(2+2); //4
//		System.out.println('2'+'2'); //100--'2'的码50，加上，'2'的码50
//
//		char c9 = '\\';
//		System.out.println(c9); //\
//		char c10 = '\"';
//		System.out.println(c10);


		//4.boolean:布尔型，1个字节
//		boolean b1 = true; //true为boolean的直接量
//		boolean b2 = false; //false为boolean的直接量
////		boolean b3 = 250; //编译错误，boolean只能取值为true和false

		/*
		 * int、long、double的练习:
		 * 1.声明整型变量a并赋值为250
		 *   声明整型变量b并赋值为100亿------???
		 *   输出5/3的值，输出3/5的值
		 *   声明整型变量c并赋值为2147483647(int的最大值)
		 *     在c本身基础之上增1，输出c的值
		 * 2.声明长整型变量d并赋值为100亿
		 *   声明长整型变量e并赋值为10亿*2*10L，输出e的值
		 *   声明长整型变量f并赋值为10亿*3*10L，输出f的值
		 *   声明长整型变量g并赋值为10亿L*3*10，输出g的值
		 *   声明长整型h并赋值System.currentTimeMills()
		 *     输出h的值
		 * 3.声明浮点型变量i并赋值为3.14159
		 *   声明浮点型变量j和k，并分别赋值为6.0和4.9
		 *     输出j-k的值
		 */
		
		/*
		3.double:浮点型，8个字节，很大很大
		*/
//		double a = 3.14159; //3.14159为浮点型直接量，默认为double型
//		float b = 3.14159f; //3.14159F为float类型的直接量
//		double c = 8;
//		System.out.println(c); //8.0
//        float cc = 8;
//        System.out.println(cc);//8.0
//        float ccc = 8F;
//        System.out.println(ccc);//8.0
//
//		double d = 3.0;
//		double e = 2.9;
//		System.out.println(d-e); //0.1000000000009---舍入误差

//		//2.long:长整型，8个字节，很大很大
//        long l = 250;//默认为int
//        System.out.println(l);
//		long a = 250L; //250L为长整型直接量
////		long b = 10000000000; //编译错误，100亿默认为int型，但是超范围了
//		long c = 10000000000L;
//
//		long d = 1000000000*2*10L;//200亿范围内，还是int类型
//		System.out.println(d); //200亿
//		long e = 1000000000*3*10L;
//		System.out.println(e); //1000000000*3超出200亿，不是(long)300亿，溢出了
//		long f = 1000000000L*3*10;
//		System.out.println(f); //300亿
//
//		//获取自1970.1.1零时到此时此刻的毫秒数
//		long g = System.currentTimeMillis();
//		System.out.println(g);
//		System.out.println(Long.MAX_VALUE);
		
		//1.int:整型，4个字节，-21个多个到21个多亿
//		int a = 250; //250为整数直接量，默认int型
//		//int b = 10000000000; //编译错误，100亿默认为int型，但是超范围了
//
//		System.out.println(5/2); //2，小数位无条件舍弃了
//		System.out.println(2/5); //0，小数位无条件舍弃了
//
//		int c = 2147483647;
//		c=c+1;
//		System.out.println(c); //-2147483648，溢出了，需要避免
//		System.out.println("这是int类型的内容！");
//		System.out.println(Integer.MAX_VALUE);	//最大值



	}
}
