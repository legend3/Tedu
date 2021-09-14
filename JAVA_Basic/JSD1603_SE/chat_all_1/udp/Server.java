package chat_all_1.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPЭ��ͨѶ�ķ����
 * @author adminitartor
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			/*
			 * �������ݵĴ�������:
			 * 1:����Socket
			 * 2:׼�����������õİ�
			 * 3:ͨ��Socket�������ݣ����������
			 *   ���ݵİ��С�
			 *   ��һ�����󣬽������ݵİ����б仯:
			 *   1:���к��н��յ���Զ�˼��������
			 *     ����������
			 *   2:����¼�����ʵ�ʽ��յ����ݳ���
			 *   3:����¼��Զ�˼������ַ��Ϣ
			 * 4:��ȡ�������ݡ�    
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
			 * DatagramPacket�ṩ�˷���getLength()
			 * �÷������Ի�ȡ������ͽ��յ����ֽ���
			 */
			String message = new String(
				data,0,packet.getLength(),"UTF-8"	
			);
			System.out.println("�ͻ���˵:"+message);
			
			/*
			 * �ظ��ͻ���
			 */
			//2
			message = "��ÿͻ���!";
			data = message.getBytes("UTF-8");
			
			/*
			 * 3 ͨ�����հ��õ�Զ�˼������ַ��Ϣ
			 */
			InetAddress address
				= packet.getAddress();
			int port = packet.getPort();
			
			//4
			packet
				= new DatagramPacket(
					data,        //������������
					data.length, //���ݳ���
					address,     //Զ�˵�ַ
					port         //Զ�˶˿�
				);
			
			//5
			socket.send(packet);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
