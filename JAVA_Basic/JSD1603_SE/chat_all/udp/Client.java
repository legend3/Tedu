package chat_all.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议通讯的客户端
 * @author adminitartor
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			/*
			 * UDP通讯流程:
			 * 1:创建Socket
			 * 2:准备要发送的数据
			 * 3:准备远端计算机地址信息
			 * 4:打包(设置数据，设置地址)
			 * 5:通过Socket将包发送至远端
			 * 若需要再次发送数据，重复2-5
			 */
			//1
			DatagramSocket socket
				= new DatagramSocket();
			
			//2
			String message = "你好服务端!";
			byte[] data
				= message.getBytes("UTF-8");
			
			//3
			InetAddress address
				= InetAddress.getByName("localhost");
			/*
			 * TCP协议的端口与UDP协议的端口是不冲突的
			 */
			int port = 8088;
			
			//4
			DatagramPacket packet
				= new DatagramPacket(
					data,        //数据所在数组
					data.length, //数据长度
					address,     //远端地址
					port         //远端端口
				);
			
			//5
			socket.send(packet);
			
			/*
			 * 接收服务端发送回来的信息
			 */
			//2
			data = new byte[100];
			packet
				= new DatagramPacket(
					data,	
					data.length
				);
			
			//3
			socket.receive(packet);
			
			//4
			/*
			 * DatagramPacket提供了方法getLength()
			 * 该方法可以获取这次世纪接收到的字节量
			 */
			message = new String(
				data,0,packet.getLength(),"UTF-8"	
			);
			System.out.println("服务端说:"+message);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








