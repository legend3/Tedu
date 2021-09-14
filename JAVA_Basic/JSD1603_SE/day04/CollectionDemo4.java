package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * �����ʹ�õĵط����Ǽ���
 * ��������Լ�������е�Ԫ�����͡�
 * @author Administrator
 *
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		/*
		 * boolean add(E e)
		 */
		c.add("one");
		c.add("two");
		c.add("three");
//		c.add(1);
		System.out.println(c);
		/*
		 * ������Ҳ֧�ַ��ͣ��÷��͵�ʵ������
		 * Ӧ����������ļ��ϵķ���ʵ������һ�¡�
		 */
		//1.
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
			it.remove();//���������Ա߱�����ɾ��
		}
//		System.out.println(c);
		//2.
		for(String str:c){//(��������Ԫ�ص����� Ԫ��:����)
			System.out.println(str);
//			c.remove("one");//���ܱ߱�����ɾ��
		}
	}
}



