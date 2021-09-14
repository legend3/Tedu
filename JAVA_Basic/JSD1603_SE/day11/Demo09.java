package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo09 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		List<Integer> list = new ArrayList<Integer>();
		t1.list = list;
		t2.list = list;
		t2.t1 = t1;
		t1.start();
		t2.start();
	}
}

class T1 extends Thread{
	/**
	 * T1负责向集合添加元素
	 */
	List<Integer> list; 
	public void run() {
		for(int i=0; i<10; i++){
			list.add((int)(Math.random()*100));
		}
		//
		System.out.println("T1:"+list); 
	}
}

class T2 extends Thread{
	/**
	 * T2负责对T1添加好元素的集合进行排序
	 */
	List<Integer> list; 
	T1 t1;
	public void run() {
		try {
			t1.join();//T2进入Block状态,等待T1运行完毕
			//等到了t1线程正常结束
			Collections.sort(list);
			System.out.println("T2:"+list);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// 发生了打断，结束了等待过程
		}
	}
}
