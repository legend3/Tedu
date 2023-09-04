package day11;

public class Demo02 {

	public static void main(String[] args) {
		DemoThread t1 = new DemoThread();//main线程执行
		DemoThread t2 = new DemoThread();
		t1.str = "A";
		t2.str = "B";

		//由cup分配的时间片决定线程的执行时间
		t1.start();//main线程执行
		t2.start();//main线程执行
	}
}
