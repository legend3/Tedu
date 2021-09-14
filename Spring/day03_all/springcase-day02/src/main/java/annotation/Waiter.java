package annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("wt")
@Lazy(true)
public class Waiter {

	public Waiter() {
		System.out.println("Waiter的无参构造器...");
	}
	
}
