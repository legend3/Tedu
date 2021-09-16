package Basic.day04;
//for循环的演示
public class ForDemo {
	public static void main(String[] args) {
//		int sum = 0;
//		for(int num=1;num<=100;num++){
//			if(num%10!=3){
//				sum+=num;
//			}
//		}
//		System.out.println("sum="+sum);

//		累加1到100的和，要求:不要个位为3的
//		int sum = 0;
//		for(int num=1;num<=100;num++){
//			if(num%10==3){
//				continue;
//			}
//			sum+=num;
//		}
//		System.out.println("sum="+sum);

		/*
		 * sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 
		 * num=4 sum=1+2+4
		 * ...
		 * num=13 
		 * num=14 sum=....
		 */

		/*
		int sum = 0;
		for(int num=1;num<=100;num++){
			if(sum>=4000){
				break; //在某种特定情况之下来跳出循环
			}
			sum+=num;
		}
		System.out.println("sum="+sum);
		*/

		/**
		 * 放外面*
		 */
//		int sum = 0;
//		int num=1;
//		for(;num<=100;num++){
//			sum+=num;
//		}
//		System.out.println("sum="+sum);
		/**
		 * 在for内外通过定义N个变量、其增量，其上下，来定义如何循环
		 */
//		int sum = 0;
//		for(int num=1;num<=100;){//
//			sum+=num;
//			num++;//放外面*
//		}
//		System.out.println("sum="+sum);
//
		/**
		 * 死循环
		 */
//		for(;;){
//			System.out.println("我要学习...");
//		}
		/**
		 * 不一定是++ *
		 */

		for(int i=0,j=6; i<5; i+=2,j-=2){
			System.out.println("i="+i + " " + "j="+j);
		}


		/**
		 * i=0,j=6
		 * i=2,j=4
		 * i=4,j=2
		 * i=6,j=0
		 */
		
		/*
		//累加和: 1+2+3+..+99+100=?
		int sum = 0; //和
		for(int num=1;num<=100;num++){
			sum+=num;
		}
		System.out.println("sum="+sum);
		*/
		/*
		 * sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 sum=1+2+3
		 * num=4 sum=1+2+3+4
		 * ...
		 * num=100 sum=1+2+3+4+..+100
		 */
		/*
		for(int times=0;times<10;times++){
			System.out.println("行动是成功的阶梯");
		}
		System.out.println("over");
		*/
		/*
		 * 执行过程:
		 * times=0 true 输出
		 * times=1 true 输出
		 * times=2 true 输出
		 * times=3 true 输出
		 * ...
		 * times=9 true 输出
		 * times=10 false for循环结束
		 * 输出over
		 */
/*

		for(int num=1;num<=9;num++){
			System.out.println(num+"*9="+num*9);
		}
		System.out.println("over");
*/
	//九九乘法表
//	for (int i=1;i<=9;i++){
//		for (int j=1;j<=i;j++) {
//			System.out.print(j + "x" + i + "=" + j*i + " ");
//			}
//		System.out.println();
//		}
	}

}











