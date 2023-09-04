package day02;
/**
 * 数字类型的包装类都支持两个常量
 * MAX_VALUE
 * MIN_VALUE
 * 分别表示该包装类对应的基本类型的取值范围
 * @author Administrator
 *
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		int imax = Integer.MAX_VALUE;
		int imin = Integer.MIN_VALUE;
		System.out.println(imax);
		System.out.println(imin);
		
		long lmax = Long.MAX_VALUE;
		long lmin = Long.MIN_VALUE;
		System.out.println(lmax);
		System.out.println(lmin);
	}
}