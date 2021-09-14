package Basic.day05;
import java.util.Arrays;
//数组的演示
public class ArrayDemo {
	public static void main(String[] args) {
		/**
		* 6.数组的排序
		*/
		//冒泡排序算法
//		int[] arr = {45,23,3,21,67,4,37,87,567,46};// 从第一个元素开始，所有元素一一跟后面的元素比较，一个元素一轮
//		for (int i=0;i<arr.length-1;i++){
//			for (int j=0;j<arr.length-1-i;j++) {
//				if (arr[j] > arr[j + 1]) {
//					int n = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = n;
//				}
//			}
//		}
//		for (int c=0;c<arr.length;c++){
//			System.out.println(arr[c]);
//		}
		// 从大到小
//		for(int i=0;i<arr.length-1;i++){ //控制轮数
//			for(int j=0;j<arr.length-1-i;j++){ //控制每一轮的次数
//				if(arr[j]<arr[j+1]){ //每一次都和它的下一个元素比
//					int t = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = t;
//				}
//				//若前数大于后数则交换，保证前数小于后数---升序
//				//若前数小于后数则交换，保证前数大于后数---降序
//			}
//		}
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}

		// 从小到大
//		int num[] = {1,2,4,6,7,2,34,243,64,567};
//		for(int i = 0;i<num.length-1;i++){  //每个元素都要去进行比较(的轮数=num.length-1)
//			for(int j=0;j<num.length-1-i;j++){//每个元素一一去与其他元素比较(的次数,num.length-1)
//				if(num[j]>num[j+1]){
//					int t = num[j];
//					num[j] = num[j+1];
//					num[j+1] = t;
//				}
//			}
//		}
//		for (int i=0;i<num.length;i++){
//			System.out.println(num[i]);
//		}
		/*
		int[] arr = {23,45,3,21,67,4,37,87,567,46};
		Arrays.sort(arr); //升序(从小到大)
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/

		/**
		* 5.数组的复制
		*/
//		int[] a = {10,20,30,40,50};
////		System.out.println(a);
//		//扩容/缩减(创建了一个新的数组，并把原始数组的数据复制过去了)
//		a = Arrays.copyOf(a, a.length-2);
////		System.out.println(a);//输出数组地址
//		for(int i=0;i<a.length;i++){
//			System.out.println(a[i]);
//		}

//		int[] a = {10,20,30,40,50};
//		//a:源数组
//		//a1:目标数组
//		//6:目标数组的长度
//		int[] a1 = Arrays.copyOf(a,6);
//		for(int i=0;i<a1.length;i++){
//			System.out.println(a1[i]);
//		}


		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6]; //0,0,0,0,0,0
		//a:源数组
		//1:源数组的起始下标
		//a1:目标数组
		//0:目标数组的起始下标
		//4:要复制的元素个数
		System.arraycopy(a,1,a1,2,4);// 从a的第二元素开始按顺序复制4个元素到a1,填充从a1的第三项开始
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}

		/*
		 * 数组的练习:
		 * 1.声明整型数组arr，包含4个元素
		 * 2.声明整型数组arr1，并直接赋值为3,6,9
		 *   声明整型数组arr2，先new并直接赋值为3,6,9
		 * 3.输出arr的长度
		 *   输出arr中第一个元素的值
		 *   给arr中第二个元素赋值为250
		 *   输出arr中最后一个元素的值---下标不能写死
		 *   arr[4]=400;--------???
		 * 4.创建类MaxOfArray，在main方法中:
		 *   1)声明整型数组arr，包含10个元素
		 *   2)循环方式给arr中每个元素赋值为0到99的随机数
		 *   3)循环方式输出arr中每个元素的值
		 */
		
		/**
		 * 4.数组的遍历
		 */
//		int[] arr = new int[10];
//		for(int i=0;i<arr.length;i++){
//			arr[i] = (int)(Math.random()*100);//给数组赋值
//		}
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}

		/**
		 3.数组的访问
		*/
//		int[] arr = new int[3];
//		System.out.println(arr.length); //输出数组的长度:3
//		System.out.println(arr[0]); //0
//		arr[0] = 100; //给arr中第1个元素赋值为100
//		System.out.println(arr[arr.length-1]); //输出arr中的最后一个元素
////		arr[3] = 300; //数组下标越界异常ArrayIndexOutOfRangeException

		/**
		2.数组的初始化(四种方式)
		*/
//		 int[] arr = new int[3]; //0,0,0
//		 int[] arr1 = {2,5,8}; //2,5,8
//		 int[] arr2 = new int[]{2,5,8}; //2,5,8
//		 int[] arr3;
//		 //arr3 = {2,5,8}; //编译错误，此方式只能声明的同时初始化
//		 arr3 = new int[]{2,5,8}; //正确的

		 /**
		 * 1.数组的定义
		 */
//		String[] strArry = new String[4];

//		int[] intArry = new int[]{1,2,3,4,5,6,7,8};

//		String[] strArry2 = {"w","o","r","l","d"};

//		int[] intArry2;
//		intArry2 = new int[6];

//		System.out.println(intArry.length);
	}
}
