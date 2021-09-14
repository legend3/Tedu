package Oop.day03;
//继承中的构造
public class CusDemo {
	public static void main(String[] args) {
		Doo o = new Doo();
	}
}

class Coo{
	Coo(){
		System.out.println("父类构造");
	}
}
class Doo extends Coo{
	Doo(){
		super();
		System.out.println("子类构造");
	}
}


class Aoo{
	int a;
	Aoo(int a){
		this.a = a;
	}
}
class Boo extends Aoo{
	Boo(){
		super(5); //调用父类的有参构造
	}
	/*
	//默认如下代码:
	Boo(){
		super();
	}
	*/
}
