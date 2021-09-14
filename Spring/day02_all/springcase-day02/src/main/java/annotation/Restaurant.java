package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Restaurant {
	//@Autowired
	//@Qualifier("wt")
	/*
	 * @Autowired和@Qualifier也可以
	 * 加到属性前面。等介于加到set方法
	 * 前面。
	 */
	private Waiter wt;

	public Restaurant() {
		System.out.println(
				"Restaurant的无参构造器...");
	}

	public Waiter getWt() {
		return wt;
	}
	
	@Autowired
	/*
	 * 默认情况下，容器会按照byType的方式进行
	 * 注入，有可能找到多个符合要求的bean。
	 * 建议使用@Qualifier来指定要注入的bean
	 * 的id。
	 */
	public void setWt(
			@Qualifier("wt") Waiter wt) {
		System.out.println(
				"Restaurant的setWt方法...");
		this.wt = wt;
	}
	

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
}
