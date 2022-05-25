package day09;

import java.io.Serializable;
/**
 * 对象流要求 被序列化的对象实现Serializable接口！
 * Java编译器在编译实现Serializable接口的对象时候，会自动的插入3个方法！
 * 这些方法将被对象流调用，用于对象序列化。
 */
public class Foo implements Serializable {
	
	/**
	 * 序列化版本号，实现Serializable时候建议添加的属性。
	 * 要保持稳定，可以避免序列化时候遇到的问题。
	 *
	 * transient 关键字
	 * 用于忽略不需要序列化的属性，这样就可以保存必须的属性，减少文件的大小。
	 */
	private static final long serialVersionUID = -43858545680L;
	
	int n;
	transient String s;

	public Foo() {
	}

	public Foo(int n, String s) {
		this.n = n;
		this.s = s;
	}

	public String toString() {
		return "Foo [n=" + n + ", s=" + s + "]";
	}
}
