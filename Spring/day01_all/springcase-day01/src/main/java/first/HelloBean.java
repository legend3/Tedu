package first;
/**
 * 	javabean
 * 		public
 *  	有包
 *  	实现序列化接口
 *  	无参构造器
 *  	属性及对应的get/set方法
 *	spring将所有被容器管理的java类都称之为一个
 *  javabean。
 */
public class HelloBean {
	public HelloBean(){
		System.out.println(
				"HelloBean的无参构造器...");
	}
	
	
}
