package com.tarena.shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

/** 主程序类 */
public class ShootGame extends JPanel {
	public static final int WIDTH = 400;  //窗口宽
	public static final int HEIGHT = 654; //窗口高
	
	public static BufferedImage background; //背景图
	public static BufferedImage start; //启动图
	public static BufferedImage pause; //暂停图
	public static BufferedImage gameover; //游戏结束图
	public static BufferedImage airplane; //敌机
	public static BufferedImage bee; //小蜜蜂
	public static BufferedImage bullet; //子弹
	public static BufferedImage hero0; //英雄机0
	public static BufferedImage hero1; //英雄机1
	
	public static final int START = 0;     //启动状态
	public static final int RUNNING = 1;   //运行状态
	public static final int PAUSE = 2;     //暂停状态
	public static final int GAME_OVER = 3; //游戏结束状态
	private int state = START; //当前状态(默认为启动状态)
	
	private Hero hero = new Hero();
	private FlyingObject[] flyings = {};
	private Bullet[] bullets = {};
	
	static{ //加载静态资源(初始化静态图片)
		try{
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/** 随机生成敌人(敌机+小蜜蜂)对象 */
	public FlyingObject nextOne(){
		Random rand = new Random(); //随机数对象
		int type = rand.nextInt(20); //生成0到19的随机数
		if(type<5){ //为0时返回小蜜蜂
			return new Bee();
		}else{ //为1到19时返回敌机
			return new Airplane();
		}
	}
	
	int flyEnteredIndex = 0; //敌人入场计数
	/** 敌人入场 */
	public void enterAction(){ //10毫秒走一次
		flyEnteredIndex++; //每10毫秒增1
		if(flyEnteredIndex%40==0){ //每400毫秒走一次
			FlyingObject obj = nextOne(); //获取敌人对象
			flyings = Arrays.copyOf(flyings,flyings.length+1); //扩容
			flyings[flyings.length-1] = obj; //将敌人赋值给flyings的最后一个元素
		}
	}
	
	/** 飞行物走一步 */
	public void stepAction(){ //10毫秒走一次
		hero.step(); //英雄机走一步
		for(int i=0;i<flyings.length;i++){ //遍历敌人数组
			FlyingObject f = flyings[i]; //获取每一个敌人
			f.step(); //敌人走一步
		}
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			Bullet b = bullets[i]; //获取每一个子弹
			b.step(); //走弹走一步
		}
	}
	
	int shootIndex = 0; //子弹入场计数
	/** 子弹入场(英雄机发射子弹) */
	public void shootAction(){ //10毫秒走一次
		shootIndex++; //每10毫秒增1
		if(shootIndex%30==0){ //300(10*30)毫秒走一次
			Bullet[] bs = hero.shoot(); //获取子弹数组
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length); //扩容(bs有几个元素则扩大几个容量)
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length); //数组的追加
		}
	}
	
	/** 删除越界的敌人和子弹 */
	public void outOfBoundsAction(){
		int index = 0; //1.不越界敌人数组下标   2.不越界敌人个数
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; //不越界敌人数组
		for(int i=0;i<flyings.length;i++){ //遍历敌人数组
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(!f.outOfBounds()){ //不越界
				flyingLives[index] = f; //将不越界敌人对象添加到不越界敌人数组中
				index++; //1.不越界敌人数组下标增一  2.不越界敌人个数增一
			}
		}
		flyings = Arrays.copyOf(flyingLives,index); //将不越界敌人数组复制到flyings中，flyings的长度为index(即不越界敌人个数)
		
		index = 0; //归零 1.不越界子弹数组下标  2.不越界子弹个数
		Bullet[] bulletLives = new Bullet[bullets.length]; //不越界子弹数组
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			Bullet b = bullets[i]; //获取每一个子弹
			if(!b.outOfBounds()){ //不越界
				bulletLives[index] = b; //将不越界子弹对象添加到不越界子弹数组中
				index++; //1.不越界子弹数组下标增一  2.不越界子弹个数增一
			}
		}
		bullets = Arrays.copyOf(bulletLives,index); //将不越界子弹数组复制到bullets中，bullets的长度为index(即不越界子弹个数)
		
	}
	
	/** 所有子弹与所有敌人撞 */
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			bang(bullets[i]); //一个子弹与所有敌人撞
		}
	}
	
	int score = 0; //得分
	/** 一个子弹与所有敌人撞 */
	public void bang(Bullet b){
		int index = -1; //被撞敌人的下标
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(f.shootBy(b)){ //撞上了
				index = i; //记录被撞敌人的下标
				break; //其余的敌人不再比较
			}
		}
		if(index!=-1){ //有撞上的
			FlyingObject one = flyings[index]; //获取被撞的敌人对象
			if(one instanceof Enemy){ //是敌人
				Enemy e = (Enemy)one; //强转为敌人
				score += e.getScore(); //玩家增分
			}
			if(one instanceof Award){ //是奖励
				Award a = (Award)one; //强转为奖励
				int type = a.getType(); //获取奖励类型
				switch(type){ //根据奖励类型的不同来获取不同的东西
				case Award.DOUBLE_FIRE:   //若奖励类型为火力值
					hero.addDoubleFire(); //英雄机增火力
					break;
				case Award.LIFE: //若奖励类型为命
					hero.addLife(); //英雄机增命
					break;
				}
			}
			//将被撞敌人对象与数组中最后一个元素交换
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			//缩容(去掉最后一个元素，即被撞的敌人对象)
			flyings = Arrays.copyOf(flyings,flyings.length-1);
		}
	}
	
	/** 检查游戏结束 */
	public void checkGameOverAction(){
		if(isGameOver()){ //游戏结束时
			state = GAME_OVER; //将当前状态改为游戏结束状态
		}
	}
	
	/** 判断游戏是否结束  返回true即游戏结束 */
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			FlyingObject f = flyings[i]; //获取每一个敌人
			if(hero.hit(f)){ //撞上了
				hero.subtractLife(); //英雄机减命
				hero.clearDoubleFire(); //英雄机清空火力
				
				//将被撞敌人与数组中最后一个元素交换
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				//缩容(去掉最后一个元素，即被撞的敌人对象)
				flyings = Arrays.copyOf(flyings,flyings.length-1);
			}
		}
		return hero.getLife()<=0; //英雄机命数<=0，则返回true，表示游戏结束
	}
	
	/** 启动程序的执行 */
	public void action(){
		//创建侦听器对象
		MouseAdapter l = new MouseAdapter(){
			/** 重写鼠标移动事件 */
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){ //运行状态下执行
					int x = e.getX(); //获取鼠标的x坐标
					int y = e.getY(); //获取鼠标的y坐标
					hero.moveTo(x, y); //英雄机随着动
				}
			}
			/** 重写鼠标点击事件 */
			public void mouseClicked(MouseEvent e){
				switch(state){ //根据当前状态做不同的处理
				case START: //启动状态时改为运行状态
					state = RUNNING;
					break;
				case GAME_OVER: //游戏结束状态时改为启动状态
					state = START;
					score = 0; //清理现场(所有数据回归原始)
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					break;
				}
			}
			/** 重写鼠标移出事件 */
			public void mouseExited(MouseEvent e){
				if(state==RUNNING){ //运行状态时
					state=PAUSE;    //改为暂停状态
				}
			}
			/** 重写鼠标移入事件 */
			public void mouseEntered(MouseEvent e){
				if(state==PAUSE){  //暂停状态时
					state=RUNNING; //改为运行状态
				}
			}
		};
		this.addMouseListener(l); //处理鼠标操作事件
		this.addMouseMotionListener(l); //处理鼠标滑动事件
		
		Timer timer = new Timer(); //定时器对象
		int intervel = 10; //定时间隔(以毫秒为单位)
		timer.schedule(new TimerTask(){
			public void run(){ //10毫秒-定时干的那个事
				if(state==RUNNING){ //运行状态下操作
					enterAction(); //敌人入场
					stepAction(); //飞行物走一步
					shootAction(); //子弹入场(英雄机发射子弹)
					outOfBoundsAction(); //删除越界的敌人和子弹
					bangAction(); //子弹与敌人的碰撞
					checkGameOverAction(); //检查游戏是否结束
				}
				repaint(); //重画(调用paint())
			}
		},intervel,intervel);
	}
	
	/** 重写paint() g:画笔 */
	public void paint(Graphics g){
		g.drawImage(background,0,0,null); //画背景图
		paintHero(g); //画英雄机对象
		paintFlyingObjects(g); //画敌人(敌机+小蜜蜂)对象
		paintBullets(g); //画子弹对象
		paintScoreAndLife(g); //画分和画命
		paintState(g); //画状态
	}
	/** 画英雄机对象 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null); //画英雄机
	}
	/** 画敌人(敌机+小蜜蜂)对象 */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){ //遍历敌人数组
			FlyingObject f = flyings[i]; //获取每一个敌人
			g.drawImage(f.image,f.x,f.y,null); //画敌人
		}
	}
	/** 画子弹对象 */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //遍历子弹数组
			Bullet b = bullets[i]; //获取每一个子弹
			g.drawImage(b.image,b.x,b.y,null); //画子弹
		}
	}
	/** 画分和画命 */
	public void paintScoreAndLife(Graphics g){
		g.setColor(new Color(0xFF0000)); //设置颜色(纯红)
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24)); //设置字体样式(字体:SANS_SERIF 样式:BOLD加粗 字号:24)
		g.drawString("SCORE: "+score,10,25); //画分
		g.drawString("LIFE: "+hero.getLife(),10,45); //画命
	}
	/** 画状态 */
	public void paintState(Graphics g){
		switch(state){ //根据当前状态画不同的图
		case START: //启动状态时画启动图
			g.drawImage(start,0,0,null);
			break;
		case PAUSE: //暂停状态时画暂停图
			g.drawImage(pause,0,0,null);
			break;
		case GAME_OVER: //游戏结束状态时画游戏结束图
			g.drawImage(gameover,0,0,null);
			break;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("fly"); //窗口对象
		ShootGame game = new ShootGame(); //面板对象
		frame.add(game); //将面板添加到窗口上
		
		frame.setSize(WIDTH, HEIGHT); //设置窗口大小
		frame.setAlwaysOnTop(true); //设置一直居上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置默认关闭操作(窗口关闭则退出)
		frame.setLocationRelativeTo(null); //设置窗口初始位置(居中显示)
		frame.setVisible(true); //1.设置窗口可见  2.尽快调用paint()
		
		game.action(); //启动程序的执行
	}
}












