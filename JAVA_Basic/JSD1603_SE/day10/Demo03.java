package day10;

public class Demo03 {

	public static void main(String[] args) {
		//将一个字符串的第一个
		// 字符转换为一个整数
		try{
			String str = null;// "1天" "";
			// '0':48 '1':49 '2':50 '3':51
			// '0'-48 '1'-48 '2'-48 ...
			char c = str.charAt(0);
			int n = c-'0';
			System.out.println(n); //1
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("你字符串太短"); 
		}catch(NullPointerException e){
			System.out.println("不能为空！"); 
		}finally{
			System.out.println("最后完成！");
		}
	}
}
