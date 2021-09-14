package chat_all_1.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
	 *   一个Socket实例与该客户端进行通讯。
	 */
	private ServerSocket server;
	
	//保存所有客户端输出流的集合
	private List<PrintWriter> allOut;
	
	
	public Server() throws IOException{
		/*
		 * 创建ServerSocket的同时需要申请服务端口
		 * 这个端口不能与其他使用TCP协议的应用程序
		 * 冲突，否则会抛出异常。
		 */
		server = new ServerSocket(8088);
		
		allOut = new ArrayList<PrintWriter>();
		
	}
	
	/**
	 * 将指定的客户端的输出流存入共享集合
	 * @param pw
	 */
	private synchronized void addOut(PrintWriter pw){
		allOut.add(pw);
	}
	/**
	 * 将指定的客户端的输出流从共享集合中删除
	 * @param pw
	 */
	private synchronized void removeOut(PrintWriter pw){
		allOut.remove(pw);
	}
	/**
	 * 广播消息，将给定的消息通过遍历共享集合将
	 * 该消息发送给每一个客户端
	 * @param message
	 */
	private synchronized void sendMessage(String message){
		for(PrintWriter pw : allOut){
			pw.println(message);
		}
	}
	
	
	
	
	public void start() throws IOException{
		while(true){
//			System.out.println("等待客户端连接...");
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
//			System.out.println("一个客户端连接了!");
			ClientHandler handler 
				= new ClientHandler(socket);
			Thread t = new Thread(handler);
			t.start();
		}
		
		
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 该类是一个线程的任务，负责与指定客户端
	 * 进行交互。
	 * @author adminitartor
	 *
	 */
	private class ClientHandler 
						implements Runnable{
		/*
		 * 当前线程需要处理的针对指定客户端的Socket
		 */
		private Socket socket;
		
		//该用户地址信息
		private String host;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			/*
			 * 通过Socket获取远程计算机地址信息
			 */
			InetAddress address
				= socket.getInetAddress();
			//获取ip地址
			host = address.getHostAddress();
		}
		public void run(){
			PrintWriter pw = null;
			try {
				sendMessage(host+"上线了!");
				
				//创建输出流，用来将消息发送至客户端
				OutputStream out 
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(out,"UTF-8");
				pw = new PrintWriter(osw,true);
				
				//将该客户端的输出流存入共享集合
				addOut(pw);
				
				/*
				 * InputStream getInputStream();
				 * Socket提供的该方法可以获取一个输入流，
				 * 通过该输入流可以读取远端计算机发送过来
				 * 的数据。
				 */
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr
					= new InputStreamReader(in,"UTF-8");
				
				BufferedReader br	
					= new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine())!=null){
					/*
					 * 使用br.readLine方法读取远端计算机
					 * 发送过来的数据时，由于客户端操作系统
					 * 不同，当断开连接时这里的反应也不相同。
					 * 当linux的客户端断开连接时:会返回null
					 * 当windows客户端断开时:会抛出异常。
					 */
//					message = br.readLine();
//					System.out.println(host+"说:"+message);
//					pw.println(host+"说:"+message);
					sendMessage(host+"说:"+message);
				}
			} catch (Exception e) {
				
			} finally{
				//客户端断开连接后的处理
				
				//将该客户端的输出流从共享集合中删除
				removeOut(pw);
				
				sendMessage(host+"下线了!");
				
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}







