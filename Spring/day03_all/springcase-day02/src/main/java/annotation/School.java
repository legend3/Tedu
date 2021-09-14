package annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 
 * 演示@Resource注解
 */
@Component("school")
@Lazy(true)
public class School {
	//@Resource(name="wt")
	private Waiter wt;
	@Value("tarena")
	private String name;
	@Value("#{config.pagesize}")
	private String pageSize;
	
	public School() {
		System.out.println("School的无参构造器...");
	}
	
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Waiter getWt() {
		return wt;
	}

	@Resource(name="wt")
	//name属性指定注入的bean的id。只支持set方式
	public void setWt(Waiter wt) {
		System.out.println("School的setWt方法...");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "School [wt=" + wt + ", name=" + name + ", pageSize=" + pageSize + "]";
	}

}
