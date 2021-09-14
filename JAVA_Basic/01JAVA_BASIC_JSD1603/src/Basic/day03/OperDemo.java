package Basic.day03;
//运算符的演示
public class OperDemo {
	public static void main(String[] args) {
		/*
		 * 数据类型转换的练习:
		 * 1.声明整型变量a并赋值为5
		 *   声明长整型变量b并赋值为a
		 *   声明整型变量c并赋值为b
		 * 2.声明长整型变量d并赋值为100亿
		 *   声明整型变量e并赋值为d，输出e
		 * 3.声明浮点型变量f并赋值为89.678
		 *   声明整型变量g并赋值为f，输出g
		 * 4.声明byte型变量b1并赋值为5
		 *   声明byte型变量b2并赋值为6
		 *   声明byte型变量b3并赋值为b1+b2
		 *
		 */
//		int a = 5;
//		long b = a; //自动类型转换(小到大)
//		int c = (int)b; //强制类型转换(大到小)
//
//		long d = 250; //自动类型转换
//		double e = 8; //自动类型转换
//
//		long f = 10000000000L;
//		int g = (int)f;
//		System.out.println("g:"+g); //强转有可能会溢出
//
//		double h = 35.9876;
//		int i = (int)h;
//		System.out.println(i); //强转有可能会精度丢失
//
//		byte b1 = 5;
//		byte b2 = 6;
//		byte b3 = (byte) (b1+b2);//两个byte相加是int类型!
//		System.out.println(b3);

		/**
		 * 6.三目/条件运算符:
		 *   1)语法:	表达式1是关系表达式或逻辑表达式,用于描述条件表达式中的条件,表达式2和表达式3可以是常量,变量或表达式
		 *       boolean（表达式1） ? 数1 （表达式2）: 数2（表达式3）
		 *   2)执行过程:
		 *       计算boolean的值:
		 *         若为true，则整个的结果为数1的值
		 *         若为false，则整个的结果为数2的值
		 */
		// 数据类型 变量 = 表达式: 表达式true时给变量赋值的返回值:表达式false时给变量赋值的返回值
		int a=55,b=8;
		int max = a>b?a:b; //找a和b中的最大值
		System.out.println("max="+max);

		/**
		 * 5.字符串连接运算符:
		 *   1)+:
		 *     1.1)两边都是数字，是做加法运算
		 *     1.2)有一边为字符串，则做字符串连接运算
		 */
//		System.out.println(10+20+""+30); //"3030"
//		System.out.println(10+20+30+""); //"60"
//		System.out.println(""+10+20+30); //"102030"
//
//		int age = 37;
//		System.out.println("age="); //age=
//		System.out.println(age);   //37
//		System.out.println("age="+age); //age=37
//		System.out.println("我的年龄是:"+age);
//		System.out.println("我今年"+age+"岁了");

		/**
		 * 4.赋值运算符:
		 *   1)简单赋值运算符:=
		 *   2)扩展赋值运算符:+=,-=,*=,/=,%=
		 */
//		int z=5;
//		z+=10; //相当于a=a+10
//		System.out.println(z); //15
//		z*=2; //相当于a=a*2
//		System.out.println(z); //30
//		z/=6; //相当于a=a/6
//		System.out.println(z); //5

		/**
		 * 3.逻辑运算符:
		 *   1)&&:短路与(并且)，两边都为真则为真，见false则false
		 *        若第一个数为false时，发生短路(后面的不执行了)
		 *     ||:短路或(或者)，有一边为真则为真，见true则true
		 *        若第一个数为true时，发生短路(后面的不执行了)
		 *     ! :逻辑非(取反)，非真则假，非假则真
		 *   2)逻辑运算是建立在关系运算的基础之上的
		 *     逻辑运算的结果也是boolean型
		 */
		//int a=5,b=10,c=5;
		/*
		boolean b4 = a>b || c++>2;
		System.out.println(b4); //true
		System.out.println(c);  //5，发生短路了
		*/
		/*
		boolean b3 = a>b && c++>2;
		System.out.println(b3); //false
		System.out.println(c);  //5，发生短路了
		*/

		/*
		boolean b2 = !(a>b);
		System.out.println(b2);      //!false=true
		System.out.println(!(a==c)); //!true=false
		*/

		/*
		System.out.println(a<b || c>=b); //true||false=true
		System.out.println(b<c || a==c); //false||true=true
		System.out.println(a<=b || b>c); //true||true=true
		System.out.println(a!=c || b<c); //false||false=false
		*/

		/*
		boolean b1 = a>b && c<=b;
		System.out.println(b1);          //false&&true=false
		System.out.println(a==c && c>b); //true&&false=false
		System.out.println(a!=c && a>b); //false&&false=false
		System.out.println(b>=c && a<b); //true&&true=true
		*/

		/**
		 * 2.关系运算符:
		 *   1)>(大于),<(小于)
		 *     >=(大于或等于),<=(小于或等于)
		 *     ==(等于),!=(不等于)
		 *   2)关系运算的结果为boolean型
		 *     关系成立则为true，关系不成立则为false
		 */
		/*
		int a=5,b=10,c=5;

		boolean b1 = a>b;
		System.out.println(b1);   //false
		System.out.println(c<b);  //true
		System.out.println(a>=c); //true
		System.out.println(c<=b); //true
		System.out.println(a==c); //true
		System.out.println(a!=c); //false
		*/







		/*
		 * 1.算术运算符:+,-,*,/,%,++,--
		 *   1)%:取余/取模，余数为0即为整除
		 *   2)++/--:自增1/自减1，可在变量前也可在变量后
		 *     2.1)单独使用时，在前在后无差别
		 *     2.2)被使用时，在前在后有差别
		 *           a++的值为a
		 *           ++a的值为a+1
		 */
		/*
		int a=5,b=5;
		System.out.println(a++); //5
		System.out.println(a);   //6
		System.out.println(++b); //6
		System.out.println(b);   //6
		*/

//		int a=5,b=5;
//		int c=a++;
//		int d=++b;
//		System.out.println(a); //6
//		System.out.println(b); //6
//		System.out.println(c); //5
//		System.out.println(d); //6

//		int a=5,b=5;
//		System.out.println(a++); //相当于a=a+1,第二次调用a是6
//		System.out.println(++b); //相当于b=b+1,第一次调用b是6
//		System.out.println(a); //6
//		System.out.println(b); //6
//
//		//	求余数
//		System.out.println(5%2); //1，商2余1
//		System.out.println(8%2); //0，商4余0--整除
//		System.out.println(2%8); //2，商0余2
//		System.out.println(8.678%2); //0.678--知道
	}
}

















