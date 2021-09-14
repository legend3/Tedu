package ioc;

public class A {
	private B b;
	
	public B getB() {
		return b;
	}

	public void setB(B b) {
		System.out.println("A的setB方法...");
		this.b = b;
	}

	public A() {
		System.out.println(
				"A的无参构造器...");
	}
	
	public void service(){
		b.f1();
	}
}
