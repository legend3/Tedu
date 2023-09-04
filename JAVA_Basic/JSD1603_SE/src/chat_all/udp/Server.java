package chat_all.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议通讯的服务端
 * @author adminitartor
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			/*
			 * 接收数据的大致流程:
			 * 1:创建Socket
			 * 2:准备接收数据用的包
			 * 3:通过Socket接收数据，并存入接收
			 *   数据的包中。
			 *   这一步过后，接收数据的包会有变化:
			 *   1:包中含有接收到的远端计算机发送
			 *     过来的数据
			 *   2:包记录了这次实际接收的数据长度
			 *   3:包记录了远端计算机地址信息
			 * 4:获取包中数据。    
			 */
			//1
			DatagramSocket socket
				= new DatagramSocket(8088);
			
			//2
			byte[] data = new byte[100];
			DatagramPacket packet
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
			String message = new String(
				data,0,packet.getLength(),"UTF-8"	
			);
			System.out.println("客户端说:"+message);
			
			/*
			 * 回复客户端
			 */
			//2
			message = "你好客户端!";
			data = message.getBytes("UTF-8");
			
			/*
			 * 3 通过接收包得到远端计算机地址信息
			 */
			InetAddress address
				= packet.getAddress();
			int port = packet.getPort();
			
			//4
			packet
				= new DatagramPacket(
					data,        //数据所在数组
					data.length, //数据长度
					address,     //远端地址
					port         //远端端口
				);
			
			//5
			socket.send(packet);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
