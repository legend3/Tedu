package day01;
/**
 * String substring(int start,int end)
 * ��ȡ��ǰ�ַ�����ָ����Χ�ڵ��ַ���
 * ͨ����JAVA API��ʹ���������ֱ�ʾ��Χʱ:
 * ���Ǻ�ͷ����β��
 * @author Administrator
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		//            01234567890123
		String str = "www.oracle.com";
		//��ȡ����
		String sub = str.substring(4,10);
		System.out.println(sub);
		
		/*
		 * ��ȡ����
		 * "http://www.tedu.cn"
		 * "www.baidu.com"
		 * "www.sohu.com.cn"
		 */
		String url = "www.sohu.com.cn";
		int start = url.indexOf(".")+1;
		int end = url.indexOf(".",start);
		String name = url.substring(start,end);
		String name2 = url.substring(start,end);
		System.out.println(name);
		System.out.println(name2);
		System.out.println(name == name2);//�����½�����
		
		/*
		 * ���ص�substring����ֻ��Ҫ����һ��
		 * ��������:��ָ��λ�ÿ�ʼ������ȡ���ַ���
		 * ĩβ
		 */
		str = url.substring(4);
		System.out.println(str);
	}
}




