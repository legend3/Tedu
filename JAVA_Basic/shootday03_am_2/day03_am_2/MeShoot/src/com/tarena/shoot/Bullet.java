package com.tarena.shoot;

/** �ӵ�: �Ƿ����� */
public class Bullet extends FlyingObject {
	private int speed = 3; //�߲��Ĳ���
	/** ���췽��  x:�ӵ���x����  y:�ӵ���y���� */
	public Bullet(int x,int y){
		image = ShootGame.bullet; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		this.x = x; //x:���̶���ֵ������������궯����
		this.y = y; //y:���̶���ֵ������������궯����
	}

	/** ��дstep() */
	public void step(){
		y-=speed; //y-(����)
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds(){
		return this.y<=-this.height; //�ӵ���y����<=�����ӵ��ĸߣ���ΪԽ��
	}
}









