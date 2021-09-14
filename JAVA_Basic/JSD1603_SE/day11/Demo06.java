package day11;

/**
 * 守护线程
 */
public class Demo06 {
	public static void main(String[] args) {
		TestThread t1 = new TestThread();
		t1.setName("T1");
		t1.time = 3000;
		
		TestThread t2 = new TestThread();
		t2.setName("T2");
		t2.time = 5000;
		
		TestThread tx = new TestThread();
		tx.setName("TX"); 
		tx.time = 10000;
		//将tx设置为后台(精灵、守护)线程
		// setDaemon 一定在线程启动之前调用
		tx.setDaemon(true);

		/**
		 * 当全部前台线程都结束时候， 如果后台线程还没有结束，
		 * 这时候后台线程将被结束！
		 */

		t1.start();
		t2.start();
		tx.start();
		
		System.out.println("Bye!");
	}
}


class TestThread extends Thread{
	int time;
	public void run() {
		System.out.println(getName()+"--Start!");
		try {
			sleep(time);//类中方法里调类中方法
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + "--END!");
	}
}
