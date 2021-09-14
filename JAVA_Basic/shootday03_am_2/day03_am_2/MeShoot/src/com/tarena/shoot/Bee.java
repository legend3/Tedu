package com.tarena.shoot;

import java.util.Random;

/** 小蜜蜂:是飞行物，也是奖励 */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; //x走步的步数
	private int ySpeed = 2; //y走步的步数
	private int awardType; //奖励的类型
	/** 构造方法 */
	public Bee(){
		image = ShootGame.bee; //图片
		width = image.getWidth(); //宽
		height = image.getHeight(); //高
		Random rand = new Random(); //随机数对象
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0到(屏幕宽-蜜蜂宽)之间的随机数
		y = -this.height; //y:负的蜜蜂的高
		awardType = rand.nextInt(2); //0到1之间的随机数
	}
	
	/** 重写getType() */
	public int getType(){
		return awardType; //返回奖励类型(0或1)
	}

	/** 重写step() */
	public void step(){
		x+=xSpeed; //x+(向左或向右)
		y+=ySpeed; //y+(向下)
		if(x>=ShootGame.WIDTH-this.width){ //若x>=屏幕宽-蜜蜂宽，即为到最右边了
			xSpeed=-1; //设置xSpeed为-1，则向左
		}
		if(x<=0){ //若x<=0，即为到最左边了
			xSpeed=1; //设置xSpeed为1，则向右
		}
	}

	/** 重写outOfBounds() */
	public boolean outOfBounds(){
		return this.y>=ShootGame.HEIGHT; //蜜蜂的y坐标>=屏幕的高，即为越界
	}
}











