package Oop.day04;
//重写的演示
public class OverrideDemo {
	public static void main(String[] args) {
		//演示:重写方法被调时，看对象的类型
		/*Aoo o1 = new Aoo();
		o1.show(); //父
		
		Boo o2 = new Boo();
		o2.show(); //子
		
		Aoo o3 = new Boo(); //向上造型
		o3.show(); //子*/
		/*
		 * 重写遵守"两同两小一大"规则:一般都是完全相同的
		 * 1.两同:
		 *   1)方法名称相同
		 *   2)参数列表相同
		 * 2.两小:
		 *   1)子类的返回值类型小于或等于父类的
		 *     1.1)void和基本类型，必须相等
		 *     1.2)引用类型，小于或等于
		 *   2)子类抛出的异常小于或等于父类的----异常后
		 * 3.一大:
		 *   1)子类的访问权限大于或等于父类的----下午
		 */
		Coo c = new Coo();
		c.show();
		c.say();
		c.test();
		c.sayHi();

//		Doo d = new Doo();
//		d.show();
//		d.say();
//		d.test();
//		d.sayHi();
	}
}

//父类大，子类小
class Coo{
	void show(){
		System.out.println("Cshow");
	}
	double say(){
		System.out.println("Csay");
		return 0.0;
	}
	Coo test(){
		System.out.println("Ctest");
		return null;
	}
	Doo sayHi(){
		System.out.println("DsayHi");
		return null;
	}
}
class Doo extends Coo{
	void show(){
		System.out.println("show");
	} //void时，必须相等
	double say(){
		System.out.println("say");
		return 2.2;
	} //基本类型时，必须相等
	Doo test(){
		System.out.println("test");
		return null;
	} //小于父类
//	Coo sayHi(){return null;} //编译错误，引用类型时，必须小于或等于
}


class Aoo{
	void show(){
		System.out.println("父类show");
	}
}
class Boo extends Aoo{
	void show(){
		System.out.println("子类show");
	}
}
