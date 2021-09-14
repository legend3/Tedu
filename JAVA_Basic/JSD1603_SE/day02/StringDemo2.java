package day02;
/**
 * String支持正则表达式的方法2:
 * String[] split(String regex)
 * 将当前字符串中按照满足正则表达式的部分进行
 * 拆分，返回所有被拆分的部分。
 * @author Administrator
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789abc";
		String regex = "[0-9]+";
		String[] array = str.split(regex);//按照regex正则表达式对str进行拆分，拆分后的部分放入array数组中
		System.out.println("被拆分为：" + array.length + "块");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		/*
		 * 图片重命名
		 */
		String imgName = "并发执行与串行执行的上下文切换对比.png";
		String[] names = imgName.split("\\.");
		imgName = System.currentTimeMillis() + "."+names[1];
		System.out.println(imgName);
		
	}
}






