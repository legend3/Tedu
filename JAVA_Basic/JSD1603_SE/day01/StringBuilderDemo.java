package day01;
/**
 * StringBuilder��Ϊ���޸��ַ�������
 * �����ֵ��ࡣ
 * ���ඨ�������ڱ༭�ַ�������ط���:
 * ����ɾ���ģ���
 * @author Administrator
 *
 */
public class StringBuilderDemo {
	public static void main(String[] args) {
		String str = "�ú�ѧϰjava";
		//String-->StringBuilder
		StringBuffer builder
			= new StringBuffer(str);
		
		//StringBuilder-->String
		str = builder.toString();
		System.out.println(str);
		
		/*
		 * StringBuilder append(String str)
		 * ��ǰ�ַ���ĩβ׷��ָ������
		 * 
		 * �ú�ѧϰjava,Ϊ���Ҹ��ù���!
		 */
		builder.append(",Ϊ���Ҹ��ù���!");
		System.out.println(builder.toString());
		
		/*
		 * StringBuilder(
		 *  int start,int end,String str)
		 * ����ǰ�ַ�����ָ����Χ�ڵ������滻Ϊ
		 * �����ַ���
		 * �ú�ѧϰjava,Ϊ���Ҹ��ù���!
		 * �ú�ѧϰjava,����Ϊ�˸ı�����!
		 */
		builder.replace(9, 17, "����Ϊ�˸ı�����!");
		System.out.println(builder.toString());
	
		/*
		 * StringBuilder delete(
		 * 			int start,int end)
		 * ɾ��ָ����Χ�ڵ��ַ���
		 * 
		 * �ú�ѧϰjava,����Ϊ�˸ı�����!
		 * ,����Ϊ�˸ı�����!
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());
	
		/*
		 * StringBuilder insert(
		 * 			int offset,String str)
		 * ��ǰ�ַ���ָ��λ�ô�����ָ������
		 * 
		 * ,����Ϊ�˸ı�����!
		 * ����,����Ϊ�˸ı�����!
		 */
		builder.insert(0, "����");
		System.out.println(builder.toString());
		
		builder.reverse();
		System.out.println(builder.toString());
	}
}








