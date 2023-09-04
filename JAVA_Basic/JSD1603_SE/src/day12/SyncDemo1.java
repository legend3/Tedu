package day12;
/**
 * 多线程并发安全问题(是否保证多线程同步监控的是同一个对象)
 * 当多个线程同时操作同一资源时，
 * 由于线程切换时机不确定，导致出现逻辑混乱。
 * 严重时可能导致系统崩溃。
 * @author adminitartor
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		/*
		 * 当一个方法中的局部内部类想引用该方法
		 * 的其他局部变量时，这个变量必须被声明为final的
		 */
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();//模拟线程切换
					System.out.println(getName()+":"+bean
					);
				}
			}
		};
		t1.setName("T1");
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();//模拟线程切换
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t2.setName("T2");
		t1.start();
		t2.start();
	}
}

class Table{
	//20个豆子
	private int beans = 20;
	/**
	 * 当一个方法被synchronized修饰后，该方法成为"同步方法"。多个线程不能同时进入到方法内部。
	 * @return
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了!");
		}
		Thread.yield();//模拟线程切换
		return beans--;
	}
}
