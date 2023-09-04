package chat_all_1.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPЭ��ͨѶ�Ŀͻ���
 * @author adminitartor
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			/*
			 * UDPͨѶ����:
			 * 1:����Socket
			 * 2:׼��Ҫ���͵�����
			 * 3:׼��Զ�˼������ַ��Ϣ
			 * 4:���(�������ݣ����õ�ַ)
			 * 5:ͨ��Socket����������Զ��
			 * ����Ҫ�ٴη������ݣ��ظ�2-5
			 */
			//1
			DatagramSocket socket
				= new DatagramSocket();
			
			//2
			String message = "��÷����!";
			byte[] data
				= message.getBytes("UTF-8");
			
			//3
			InetAddress address
				= InetAddress.getByName("localhost");
			/*
			 * TCPЭ��Ķ˿���UDPЭ��Ķ˿��ǲ���ͻ��
			 */
			int port = 8088;
			
			//4
			DatagramPacket packet
				= new DatagramPacket(
					data,        //������������
					data.length, //���ݳ���
					address,     //Զ�˵�ַ
					port         //Զ�˶˿�
				);
			
			//5
			socket.send(packet);
			
			/*
			 * ���շ���˷��ͻ�������Ϣ
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
			 * DatagramPacket�ṩ�˷���getLength()
			 * �÷������Ի�ȡ������ͽ��յ����ֽ���
			 */
			message = new String(
				data,0,packet.getLength(),"UTF-8"	
			);
			System.out.println("�����˵:"+message);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








