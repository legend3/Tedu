package day11;

public class DemoThread extends Thread {
	String str;

	@Override
	public void run() {
		for(int i=0; i<100; i++){
			System.out.println(i+"->"+str);
		}
	}
}
