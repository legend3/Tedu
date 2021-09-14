package com.tarena.shoot;

import java.util.Random;

/** С�۷�:�Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; //x�߲��Ĳ���
	private int ySpeed = 2; //y�߲��Ĳ���
	private int awardType; //����������
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		Random rand = new Random(); //���������
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0��(��Ļ��-�۷��)֮��������
		y = -this.height; //y:�����۷�ĸ�
		awardType = rand.nextInt(2); //0��1֮��������
	}
	
	/** ��дgetType() */
	public int getType(){
		return awardType; //���ؽ�������(0��1)
	}

	/** ��дstep() */
	public void step(){
		x+=xSpeed; //x+(���������)
		y+=ySpeed; //y+(����)
		if(x>=ShootGame.WIDTH-this.width){ //��x>=��Ļ��-�۷����Ϊ�����ұ���
			xSpeed=-1; //����xSpeedΪ-1��������
		}
		if(x<=0){ //��x<=0����Ϊ���������
			xSpeed=1; //����xSpeedΪ1��������
		}
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds(){
		return this.y>=ShootGame.HEIGHT; //�۷��y����>=��Ļ�ĸߣ���ΪԽ��
	}
}











