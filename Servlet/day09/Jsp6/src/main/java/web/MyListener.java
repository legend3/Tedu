package web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 *	监听器用来监听某些事件：
 *	1.对象的创建和销毁事件；
 *	2.添加、修改、删除数据事件；
 *	只有request、session、ServletContext
 *	有相关的监听器。
 */
public class MyListener 
	implements ServletRequestListener {

	//request销毁事件
	public void requestDestroyed(
			ServletRequestEvent arg0) {
		System.out.println("request被销毁");
	}

	//request初始化事件
	public void requestInitialized(
			ServletRequestEvent e) {
		System.out.println("request初始化");
		System.out.println(e.getServletRequest());
	}

}






