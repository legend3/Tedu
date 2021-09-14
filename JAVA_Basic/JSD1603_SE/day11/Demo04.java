package day11;

public class Demo04 {

	public static void main(String[] args) {
		DemoThread t1 = new DemoThread();
		System.out.println(t1.getPriority());//默认：5
		t1.str="A";
		t1.setPriority(1);

		DemoThread t2 = new DemoThread();
		t2.str = "B";

		DemoThread t3 = new DemoThread();
		t3.str = "C";
		t3.setPriority(10); 
		
		t1.start();
		t2.start();
		t3.start();

	}

}
