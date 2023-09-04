package day11;

public class Demo08 {
	public static void main(String[] args) {
		Thread3 t1 = new Thread3();
		Thread3 t2 = new Thread3();
		t1.str = "A";
		t2.str = "B";
		t1.start();
		t2.start();
	}
}
class Thread3 extends Thread{
	String str;
	public void run() {
		for(int i=0; i<100; i++){
			System.out.println(getName() + "->" + str);
			/**
			 * 在运行期间，让出当前线程正在占用的
			 * 处理器资源。
			 */
//			yield();//(当前线程)返回Runnable状态
		}
	}
}


