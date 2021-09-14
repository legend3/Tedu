package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bar")
@Lazy(true)
public class Bar {
	private Waiter wt;
	
	public Bar() {
		System.out.println("Bar的无参构造器...");
	}

//	@Autowired
	public Bar(@Qualifier("wt") Waiter wt) {
		System.out.println("Bar的有参构造器...");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Bar [wt=" + wt + "]";
	}
	
}
