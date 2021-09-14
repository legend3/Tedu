package day10;

public class Demo08 {
	public static void main(String[] args) {
		MyThread t = new MyThread();//实例化子实例，创建线程对象
		/**
		 * start 用于启动线程。
		 * start方法将线程对象交给操作系统
		 * 由操作系统来调用执行run方法
		 */
		t.start();//启动线程对象
	}
}
