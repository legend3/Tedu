package com.tarena.shoot;
import java.awt.image.BufferedImage;

/** 飞行物 */
public abstract class FlyingObject {
	protected BufferedImage image; //图片
	protected int width; //宽
	protected int height; //高
	protected int x; //x坐标
	protected int y; //y坐标
	
	/** 飞行物走一步 */
	public abstract void step();
	
	/** 检查飞行物是否出界 */
	public abstract boolean outOfBounds();

	/** 敌人被子弹射击 this:敌人 bullet:子弹 */
	public boolean shootBy(Bullet bullet){
		int x1 = this.x;             //x1:敌机的x
		int x2 = this.x+this.width;  //x2:敌机的x+敌机的宽
		int y1 = this.y;             //y1:敌机的y
		int y2 = this.y+this.height; //y2:敌机的y+敌机的高
		int x = bullet.x;            //x:子弹的x
		int y = bullet.y;            //y:子弹的y
		
		return x>x1 && x<x2
			   &&
			   y>y1 && y<y2; //x在x1和x2之间，并且，y在y1和y2之间，即为撞上了
	}
	
}













