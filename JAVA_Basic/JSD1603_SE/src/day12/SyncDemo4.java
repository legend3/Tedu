package day12;
/**
 * synchronized也成为"互斥锁"
 * 当synchronzed修饰的是两段代码，但是"锁对象"相同时，这两段代码就是互斥的。
 * @author adminitartor
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo b = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				b.methodA();//线程1调用方法A
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				b.methodB();//线程2调用方法B
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在调用方法A");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"调用方法A完毕");
	}
	public synchronized void methodB(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在调用方法B");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"调用方法B完毕");
	}
}







