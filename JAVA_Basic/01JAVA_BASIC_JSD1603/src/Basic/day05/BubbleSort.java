package Basic.day05;
//冒泡排序
public class BubbleSort {
	public static void main(String[] args) {
		/*
		 * 1.创建整型数组arr，包含10个元素
		 * 2.给arr中每个元素赋值为0到99的随机数
		 *   输出arr中的每一个元素
		 * 3.冒泡算法对arr进行升序排列
		 * 4.输出arr数组排序后的数据
		 */
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		//排序前后
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		System.out.println("排序后《从小到大》:");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		//排序前《从大到小》
		for(int i=0;i<arr.length;i++){//多少个数需要遍历比较
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]<arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

				}
			}
		}
		System.out.println("从大到小排序后：\n");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}














