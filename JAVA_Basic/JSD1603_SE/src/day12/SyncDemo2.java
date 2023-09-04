package day12;
/**
 * 有效的缩小同步范围可以保证在
 * 安全的前提下提高了并发的效率
 * @author adminitartor
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.setName("T1");
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t2.setName("T2");
		t1.start();
		t2.start();
	}
}

class Shop{
	/*
	 * 在方法上使用synchroinzed，同步监视器对象即当前方法所属对象:this
	 */
//	public synchronized void buy(){
	public void buy(){
		try{
			Thread t = Thread.currentThread();
			System.out.println(t+"正在挑选衣服..");
			Thread.sleep(5000);
			/*
			 * 同步块可以缩小同步范围。
			 * 但是必须保证"同步监视器"即:"上锁对象"是同一个才可以。
			 * 通常，在一个方法中使用this所谓同步监视器对象即可。
			 */
			synchronized (this) {
				System.out.println(t+"正在试衣服..");
				Thread.sleep(5000);
			}		
			System.out.println(t+"结账离开");
		}catch(Exception e){
		}
	}
}
