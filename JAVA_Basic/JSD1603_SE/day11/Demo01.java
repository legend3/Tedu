package day11;

public class Demo01 {
	public static void main(String[] args) {
		//创建Runnable接口的子类对象
		MyRunner runner = new MyRunner();//创捷Runnable接口的子类实例(作为线程参数)
		//创建线程对象，以Runnable子类对象作为参数
		Thread t = new Thread(runner, "线程名xxx");//创建线程对象，用接口子类实例作为参数
		//使用start启动线程。
		t.start();
		System.out.println(t.getName() + " -- Start!");
	}
}

class MyRunner implements Runnable {//实现Runnable接口方式
	@Override
	public void run() {//重写run()方法
		System.out.println("Hello World!");
	}
}
