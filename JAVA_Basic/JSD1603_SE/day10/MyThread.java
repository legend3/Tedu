package day10;

public class MyThread extends Thread {//继承Thread父类方式
	@Override
		public void run() {//重写run()方法
		System.out.println("Hello World!");
	}
}
