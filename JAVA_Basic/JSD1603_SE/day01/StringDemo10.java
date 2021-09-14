package day01;
/**
 * 频繁修改字符串带来的性能问题
 * @author Administrator
 *
 */
public class StringDemo10 {
	public static void main(String[] args) {
		String str = "a";				
		for(int i=0;i<10;i++){
			str+=str;
			System.out.println(System.identityHashCode(str));//可以返回对象的内存地址,不管该对象的类是否重写了hashCode()方法
		}
		
	}
}




