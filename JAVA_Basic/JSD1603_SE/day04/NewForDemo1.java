package day04;
/**
 * JDK1.5之后推出了一个新的特性
 * 增强for循环，也称为:新循环，增强循环，for_each
 * 
 * 新循环的作用是遍历集合或数组的。
 * 
 * @author Administrator
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four","five"};
		
		for(int i=0;i<array.length;i++){
			String str = array[i];
			System.out.println(i+":"+str);
		}
		
		for(String str:array){//元素类型 元素变量名:集合/数组
			System.out.println(str);
		}
	}
}




