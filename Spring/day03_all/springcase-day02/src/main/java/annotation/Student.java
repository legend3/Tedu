package annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 演示组件扫描
 *	默认情况下，bean的id等于首字母小写之后的类名。
 */
@Component("stu")
@Scope("singleton")//默认就是：singleton
@Lazy(true)//调用时才会被创建
public class Student {
	
	@PostConstruct
	public void init(){
		System.out.println("Student的init方法...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Student的destroy方法只针对singleton作用域时有效...");
	}
	
	public Student() {
		System.out.println("Student的无参构造器...");
	}
	
}
