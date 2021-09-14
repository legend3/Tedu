package day12.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室服务端
 * /sbin/ifconfig
 * 
 * ipconfig
 * 
 * @author adminitartor
 *
 */
public class Server {
	/*
	 * java.net.ServerSocket
	 * 运行在服务端的ServerSocket有两个作用:
	 * 1:申请服务端口(客户端通过该端口与服务端建立连接)
	 * 2:监听该端口，一旦客户端通过该端口连接后，会创建
	 * 一个Socket实例与该客户端进行通讯。
	 */
	private ServerSocket server;
	
	public Server() throws IOException{
		/*
		 * 创建ServerSocket的同时需要申请服务端口
		 * 这个端口不能与其他使用TCP协议的应用程序
		 * 冲突，否则会抛出异常。
		 */
		server = new ServerSocket(8088);
	}
	
	public void start() throws IOException{
		System.out.println("等待客户端连接...");
		/*
		 * Socket accept()
		 * ServerSocket提供了accept方法用来监听
		 * 打开的服务端口，一旦一个客户端通过该端口
		 * 请求时，就会创建一个Socket并返回。通过
		 * 该Socket就可以与客户端进行交互了。
		 * 
		 * 该方法是一个阻塞方法，直到客户端连接才会
		 * 有返回值。
		 */
		Socket socket = server.accept();
		System.out.println("一个客户端连接了!");
		
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}