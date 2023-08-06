package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈结构
 * 存放一组元素，但是存取元素必须遵循先进后出原则
 * java没有为栈提供专门的类，而是使用双端队列
 * 实现的。java.util.Deque
 * 双端队列:队列两端都可以进出队。
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		/*
		 * void push(E e)
		 * 入栈操作。
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		
		System.out.println(stack);
		/*
		 * E pop()
		 * 出栈操作，获取后该元素即从栈中被
		 * 删除。
		 */
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack);
		//仅引用栈顶元素，不做出栈操作
		str = stack.peek();
		System.out.println(str);
		System.out.println(stack);
		
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
		System.out.println(stack);
	}
}
