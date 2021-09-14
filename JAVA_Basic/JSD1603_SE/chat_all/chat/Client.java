package chat_all.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 聊天室客户端
 * @author adminitartor
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * 套接字，封装了TCP协议的通讯
	 * 使用Socket可以连接服务端，连接后可以创建
	 * 一个输入流与一个输出流，使用输出流用于将
	 * 数据发送至服务端，通过输入流用于读取服务端
	 * 发送过来的数据，从而实现与服务端的通讯。
	 */
	private Socket socket;
	/**
	 * 构造方法，用来初始化客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client() throws Exception{
		/*
		 * 初始化Socket就是连接远端计算机的过程
		 * 参数1:远端计算机地址
		 * 参数2:远端计算机端口
		 * 
		 * 通过地址可以找到网络上的服务端计算机，
		 * 通过端口可以找到服务端计算机上运行的
		 * 服务端应用程序，从而与之建立连接。
		 * 
		 * 若连接成功，构造方法会返回Socket实例
		 * 失败会抛出异常。
		 */
		socket = new Socket("localhost",8088);
	}
	/**
	 * 启动方法，用来执行客户端业务逻辑
	 * @throws IOException 
	 */
	public void start() throws IOException{
		Scanner scanner = new Scanner(System.in);
		
		//启动用于读取服务端发送消息的线程
		ServerHandler handler = new ServerHandler();
		Thread t = new Thread(handler);
		t.start();
		
		/*
		 * OutputStream getOutputStream()
		 * Socket提供的该方法是用来获取一个输出
		 * 流，通过该输出流写出的数据会被发送至
		 * 远端计算机(对客户端而言远端计算机就是
		 * 服务端)
		 */
		OutputStream out = socket.getOutputStream();
		
		OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
		
		PrintWriter pw = new PrintWriter(osw,true);

		String message = null;
		while(true){
			message = scanner.nextLine();
			pw.println(message);
		}
		
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 该线程负责一直读取服务端发送过来的消息，
	 * 并输出到控制台显示给用户。
	 * @author adminitartor
	 *
	 */
	private class ServerHandler 
					implements Runnable{
		public void run(){
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
			} catch (Exception e) {
				
			}
		}
	}
	
}











