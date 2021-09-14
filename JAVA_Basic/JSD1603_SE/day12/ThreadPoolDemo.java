package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 解决了两个问题:
 * 1:控制线程数量
 * 2:重用线程
 * 大量并发运行的线程会导致CPU过度切换，一起内存
 * 消耗，严重时可能导致系统崩溃。
 * 当需要频繁的创建线程，或线程数量过多时，应当考虑
 * 使用线程池来维护管理线程。 
 * 
 * @author adminitartor
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//创建固定大小线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runnable = new Runnable(){
				@Override
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+"正在执行一个任务!");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println(t+"被中断了!");
					}
					System.out.println(t+"执行任务完毕!");
				}
			};
			System.out.println("指派任务"+i+"给线程池");
			threadPool.execute(runnable);
		}
		/*
		 * shutdown方法关闭线程池是在线程池中
		 * 所有任务都被执行完毕后进行关闭的。
		 * 而shutdownNow则是立即关闭线程池。
		 */
//		threadPool.shutdown();
		threadPool.shutdownNow();
		System.out.println("关闭了线程池!");
	}
}
