package annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 演示组件扫描
 *	默认情况下，bean的id等于首字母小写之后的
 * 类名。
 */
@Component("stu")
@Scope("singleton")
@Lazy(true)
public class Student {
	
	@PostConstruct
	public void init(){
		System.out.println(
				"Student的init方法...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println(
				"Student的destroy方法...");
	}
	
	public Student() {
		System.out.println(
				"Student的无参构造器...");
	}
	
}
