package day01;
/**
 * 检查字符串是否为回文
 * @author Administrator
 *
 */
public class StringDemo6 {
	public static void main(String[] args) {
		String str = "上海自来水来自海上";
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!= str.charAt(str.length() -1 -i)) {
				System.out.println("不是回文!");
				/*
				 * 当方法返回值为void时，可以单独
				 * 使用return来终止方法。其后代码不会再被执行。
				 */
				return;
			}
		}
		System.out.println("是回文!");
	}
}





