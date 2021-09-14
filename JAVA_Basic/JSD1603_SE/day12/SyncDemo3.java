package day12;
/**
 * 静态方法被synchronized修饰后，同步监视器对象为:当前类对象
 * 由于一个类只有一个类对象，所以该静态方法一定具备同步效果。
 * 类对象:Class的实例，JVM在加载一个类的时候会
 * 创建一个Class实例用于表示它。所以每个类只有
 * 且仅有一个Class的实例。静态方法就是将该对象
 * 上锁，所以静态方法若被synchronized修饰后一
 * 定具有同步效果。
 * @author adminitartor
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		 final Foo f1 = new Foo();
		 final Foo f2 = new Foo();
		 Thread t1 = new Thread(){
			public void run(){
				f1.dosome();
			}
		 };
		 Thread t2 = new Thread(){
			public void run(){
				f2.dosome();
			} 
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在运行dosome方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t+"运行dosome方法完毕");
	}
}









