package day11;

/**
 *	线程生命周期演示
 *	new-线程被创建-start()
 *	RUNNABLE-获取时间片
 *	RUNNING-执行(获取的时间片)任务-run()
 *	TERMINATED-终止
 *
 */
public class Demo05 {
	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(){
			public void run(){
				System.out.println("Hello!");
				//输出正在运行状态的线程状态信息
				System.out.println(getState());
				System.out.println(isAlive());
			}
		};
		//输出新建状态的线程状态信息
		System.out.println(t1.getState());
		System.out.println(t1.isAlive()); 
		t1.start();
		/**
		 * 等待1秒，目的是等待线程t1一定已经结束
		 * run方法的执行，进入到死亡状态！
		 */
		Thread.sleep(1000);
		//输出死亡状态的线程状态信息
		System.out.println(t1.getState());
		System.out.println(t1.isAlive());
		/**
		 * 死亡状态的线程不能再次启动运行！
		 */
		t1.start();
	}
}
