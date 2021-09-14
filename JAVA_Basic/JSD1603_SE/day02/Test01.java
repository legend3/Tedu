package day02;
/**
 * ��ҵ3
 * @author Administrator
 *
 */
public class Test01 {

	public static void main(String[] args) {
		String str = "someapp/manager/emplist.action";
		int index = str.lastIndexOf("/")+1;
		String sub = str.substring(index);
		System.out.println(sub);
	}

}
