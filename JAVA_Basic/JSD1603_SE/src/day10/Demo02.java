package day10;

public class Demo02 {

	public static void main(String[] args) {
		//内存泄露现象
		String[] ary = new String[5000000];
		for(int i=0; i<ary.length; i++){
			String s = new String(i+"早晨好！");
			/*
			 * 将字符串的引用存储到数组中，使字
			 * 符串对象不能被垃圾回收，照成
			 * 内存泄露！出现错误OutOfMemoryError
			 * 如果字符串使用之后，及时释放引用
			 * 垃圾回收器会正常释放对象占用的内存，
			 * 程序就可以正常执行.
			 */
			ary[i] = s;
			s=null;
		}
	}
}
