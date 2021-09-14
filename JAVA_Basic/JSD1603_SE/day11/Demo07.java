package day11;

public class Demo07 {
	public static void main(String[] args) {
		SleepThread t1 = new SleepThread();
		SleepThread t2 = new SleepThread();
		t1.setName("线程1");
		t2.setName("线程2");
		t1.time = 1000;
		t2.time = 5000;

		t1.other = t2;

		t1.start();
		t2.start();
	}
}
class SleepThread extends Thread{
	int time;
	SleepThread other;
	public void run() {
		System.out.println(getName()+" 开始");
		try {
			sleep(time);
			System.out.println(getName()+":大梦谁先醒！");
			// 在t1 中叫醒 t2
			other.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(getName()+":吵醒不高兴！");
		}
		System.out.println(getName()+" 结束");
	}
}