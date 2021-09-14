package other;
/**
 * 
 * 演示生命周期相关的几个方法
 */
public class MessageBean {
	
	public MessageBean() {
		System.out.println("MessageBean的"
				+ "无参构造器...");
	}

	//初始化方法
	public void init(){
		System.out.println("MessageBean的"
				+ "init方法...");
	}
	
	public void sendMsg(){
		System.out.println("MessageBean的"
				+ "sendMsg方法...");
	}
	
	//销毁方法。
	public void destroy(){
		System.out.println("MessageBean的"
				+ "destroy方法...");
	}
	
	
}
