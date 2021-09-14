package day11;

public class Demo03 {
	/**
	 * Demo03-main-Thread1、Thread2
	 * Thread1-Demo03-test()、Thread2-Demo03-test()
	 * @param args
	 */
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		System.out.println("Over!"); 
		
		/**
		 * 1. Java 启动时候会自动创建并且启动主线程
		 * 2. main 被Java主线程调用。
		 */
		Thread t = Thread.currentThread();
		System.out.println("主线程：" + t.getName()+","+t.getId());
	}
	/**
	 * test方法被Thread1 和Thread2 并发调用
	 */
	public void test(){
		//调用方法的当前线程是谁？
		System.out.println("test"); 
		//利用Thread类提供了一个静态工具方法
		// 获取正当调用方法的线程对象！
		// current 当前
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+","+t.getId());
	}
}
class Thread2 extends Thread{
	public void run() {
		Demo03 d = new Demo03();
		d.test();
	}
}
class Thread1 extends Thread{
	public void run() {
		Demo03 d = new Demo03();
		d.test();
	}
}
