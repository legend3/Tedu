package day08;

public class Demo03 {

	public static void main(String[] args) throws Exception{
		String str = "今天你吃了吗？ABC";
		for(int i=0; i<str.length();i++){
			char c = str.charAt(i);
			System.out.println(Integer.toBinaryString(c));
		}
		//将字符串序列化为byte数据的方法
		//字符串的序列化称为：字符串编码
		//字符串编码: 方案之一是 UTF-16BE
		// UTF-8 国际化最优编码
		// GBK 中国本地化最优编码
		byte[] buf= str.getBytes();
		for (int b : buf) {
			System.out.println(Integer.toBinaryString(b&0xff));
		}
		
		String encoding = System.getProperty("file.encoding");
		
		System.out.println(encoding);
	}

}
