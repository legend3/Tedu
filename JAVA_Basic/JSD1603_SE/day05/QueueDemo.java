package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列，用于存放一组元素，但是存取元素必须遵循:先进先出原则
 * 队列通常用来解决具有排队需求的业务逻辑
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		/*
		 * 队列常用实现类:LinkedList
		 * 原因在于:
		 * LinkedList可以存放一组元素，而且
		 * 有序，最重要的是首尾增删速度快，这
		 * 满足队列所有要求。
		 */
		Queue<String> queue = new LinkedList<String>();
		
		/*
		 * boolean offer(E e)
		 * 将给定元素进行入队操作，添加到
		 * 队列末尾。
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		queue.offer("five");
		
		System.out.println(queue);
		
		/*
		 * E poll()
		 * 对元素进行出队操作，获取队列第一个
		 * 元素，并且获取后该元素就从队列中
		 * 被删除了。
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * E peek()
		 * 若仅想引用队首元素而不做出队操作，
		 * 那么可以使用peek方法。
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		//遍历队列是一次性的
		while(queue.size()>0){
			str = queue.poll();
			System.out.println(str);
		}
		System.out.println("遍历完毕!");
		System.out.println(queue);
	}
}






