package ioc2;

public class A {
	private B b;

	
	public A() {
		System.out.println("A的无参构造器...");
	}


	public A(B b) {
		System.out.println("A的有参构造器...");
		this.b = b;
	}
	
	public void service(){
		b.f1();
	}
	
}
