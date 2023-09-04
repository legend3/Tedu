package day02;
/**
 * String支持正则表达式的方法1:
 * boolean matches(String regex)
 * 使用给定的正则表达式来验证当前字符串
 * 是否满足格式要求，满足则返回true
 * @author Administrator
 *
 */
public class StringDemo1{
	public static void main(String[] args) {
		/*
		 * 电子邮箱的正则:
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+	
		 *  
		 */
		//定义正则表达式
		String regex = "[a-zA-Z0-9_] + @[a-zA-Z0-9] + (\\.[a-zA-Z]+)+";	//	"\\\\"--->\'\"\\"(字符串中)
		String email = "fancq@tedu.com";//被正则表达式匹配的对象
		boolean matches = email.matches(regex);//匹配
		if(matches){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
	}
}






