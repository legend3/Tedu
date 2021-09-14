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

/** �������� */
public class ShootGame extends JPanel {
	public static final int WIDTH = 400;  //���ڿ�
	public static final int HEIGHT = 654; //���ڸ�
	
	public static BufferedImage background; //����ͼ
	public static BufferedImage start; //����ͼ
	public static BufferedImage pause; //��ͣͼ
	public static BufferedImage gameover; //��Ϸ����ͼ
	public static BufferedImage airplane; //�л�
	public static BufferedImage bee; //С�۷�
	public static BufferedImage bullet; //�ӵ�
	public static BufferedImage hero0; //Ӣ�ۻ�0
	public static BufferedImage hero1; //Ӣ�ۻ�1
	
	public static final int START = 0;     //����״̬
	public static final int RUNNING = 1;   //����״̬
	public static final int PAUSE = 2;     //��ͣ״̬
	public static final int GAME_OVER = 3; //��Ϸ����״̬
	private int state = START; //��ǰ״̬(Ĭ��Ϊ����״̬)
	
	private Hero hero = new Hero();
	private FlyingObject[] flyings = {};
	private Bullet[] bullets = {};
	
	static{ //���ؾ�̬��Դ(��ʼ����̬ͼƬ)
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

	/** ������ɵ���(�л�+С�۷�)���� */
	public FlyingObject nextOne(){
		Random rand = new Random(); //���������
		int type = rand.nextInt(20); //����0��19�������
		if(type<5){ //Ϊ0ʱ����С�۷�
			return new Bee();
		}else{ //Ϊ1��19ʱ���صл�
			return new Airplane();
		}
	}
	
	int flyEnteredIndex = 0; //�����볡����
	/** �����볡 */
	public void enterAction(){ //10������һ��
		flyEnteredIndex++; //ÿ10������1
		if(flyEnteredIndex%40==0){ //ÿ400������һ��
			FlyingObject obj = nextOne(); //��ȡ���˶���
			flyings = Arrays.copyOf(flyings,flyings.length+1); //����
			flyings[flyings.length-1] = obj; //�����˸�ֵ��flyings�����һ��Ԫ��
		}
	}
	
	/** ��������һ�� */
	public void stepAction(){ //10������һ��
		hero.step(); //Ӣ�ۻ���һ��
		for(int i=0;i<flyings.length;i++){ //������������
			FlyingObject f = flyings[i]; //��ȡÿһ������
			f.step(); //������һ��
		}
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			Bullet b = bullets[i]; //��ȡÿһ���ӵ�
			b.step(); //�ߵ���һ��
		}
	}
	
	int shootIndex = 0; //�ӵ��볡����
	/** �ӵ��볡(Ӣ�ۻ������ӵ�) */
	public void shootAction(){ //10������һ��
		shootIndex++; //ÿ10������1
		if(shootIndex%30==0){ //300(10*30)������һ��
			Bullet[] bs = hero.shoot(); //��ȡ�ӵ�����
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length); //����(bs�м���Ԫ�������󼸸�����)
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length); //�����׷��
		}
	}
	
	/** ɾ��Խ��ĵ��˺��ӵ� */
	public void outOfBoundsAction(){
		int index = 0; //1.��Խ����������±�   2.��Խ����˸���
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; //��Խ���������
		for(int i=0;i<flyings.length;i++){ //������������
			FlyingObject f = flyings[i]; //��ȡÿһ������
			if(!f.outOfBounds()){ //��Խ��
				flyingLives[index] = f; //����Խ����˶�����ӵ���Խ�����������
				index++; //1.��Խ����������±���һ  2.��Խ����˸�����һ
			}
		}
		flyings = Arrays.copyOf(flyingLives,index); //����Խ��������鸴�Ƶ�flyings�У�flyings�ĳ���Ϊindex(����Խ����˸���)
		
		index = 0; //���� 1.��Խ���ӵ������±�  2.��Խ���ӵ�����
		Bullet[] bulletLives = new Bullet[bullets.length]; //��Խ���ӵ�����
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			Bullet b = bullets[i]; //��ȡÿһ���ӵ�
			if(!b.outOfBounds()){ //��Խ��
				bulletLives[index] = b; //����Խ���ӵ�������ӵ���Խ���ӵ�������
				index++; //1.��Խ���ӵ������±���һ  2.��Խ���ӵ�������һ
			}
		}
		bullets = Arrays.copyOf(bulletLives,index); //����Խ���ӵ����鸴�Ƶ�bullets�У�bullets�ĳ���Ϊindex(����Խ���ӵ�����)
		
	}
	
	/** �����ӵ������е���ײ */
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			bang(bullets[i]); //һ���ӵ������е���ײ
		}
	}
	
	int score = 0; //�÷�
	/** һ���ӵ������е���ײ */
	public void bang(Bullet b){
		int index = -1; //��ײ���˵��±�
		for(int i=0;i<flyings.length;i++){ //�������е���
			FlyingObject f = flyings[i]; //��ȡÿһ������
			if(f.shootBy(b)){ //ײ����
				index = i; //��¼��ײ���˵��±�
				break; //����ĵ��˲��ٱȽ�
			}
		}
		if(index!=-1){ //��ײ�ϵ�
			FlyingObject one = flyings[index]; //��ȡ��ײ�ĵ��˶���
			if(one instanceof Enemy){ //�ǵ���
				Enemy e = (Enemy)one; //ǿתΪ����
				score += e.getScore(); //�������
			}
			if(one instanceof Award){ //�ǽ���
				Award a = (Award)one; //ǿתΪ����
				int type = a.getType(); //��ȡ��������
				switch(type){ //���ݽ������͵Ĳ�ͬ����ȡ��ͬ�Ķ���
				case Award.DOUBLE_FIRE:   //����������Ϊ����ֵ
					hero.addDoubleFire(); //Ӣ�ۻ�������
					break;
				case Award.LIFE: //����������Ϊ��
					hero.addLife(); //Ӣ�ۻ�����
					break;
				}
			}
			//����ײ���˶��������������һ��Ԫ�ؽ���
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			//����(ȥ�����һ��Ԫ�أ�����ײ�ĵ��˶���)
			flyings = Arrays.copyOf(flyings,flyings.length-1);
		}
	}
	
	/** �����Ϸ���� */
	public void checkGameOverAction(){
		if(isGameOver()){ //��Ϸ����ʱ
			state = GAME_OVER; //����ǰ״̬��Ϊ��Ϸ����״̬
		}
	}
	
	/** �ж���Ϸ�Ƿ����  ����true����Ϸ���� */
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){ //�������е���
			FlyingObject f = flyings[i]; //��ȡÿһ������
			if(hero.hit(f)){ //ײ����
				hero.subtractLife(); //Ӣ�ۻ�����
				hero.clearDoubleFire(); //Ӣ�ۻ���ջ���
				
				//����ײ���������������һ��Ԫ�ؽ���
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = t;
				//����(ȥ�����һ��Ԫ�أ�����ײ�ĵ��˶���)
				flyings = Arrays.copyOf(flyings,flyings.length-1);
			}
		}
		return hero.getLife()<=0; //Ӣ�ۻ�����<=0���򷵻�true����ʾ��Ϸ����
	}
	
	/** ���������ִ�� */
	public void action(){
		//��������������
		MouseAdapter l = new MouseAdapter(){
			/** ��д����ƶ��¼� */
			public void mouseMoved(MouseEvent e){
				if(state==RUNNING){ //����״̬��ִ��
					int x = e.getX(); //��ȡ����x����
					int y = e.getY(); //��ȡ����y����
					hero.moveTo(x, y); //Ӣ�ۻ����Ŷ�
				}
			}
			/** ��д������¼� */
			public void mouseClicked(MouseEvent e){
				switch(state){ //���ݵ�ǰ״̬����ͬ�Ĵ���
				case START: //����״̬ʱ��Ϊ����״̬
					state = RUNNING;
					break;
				case GAME_OVER: //��Ϸ����״̬ʱ��Ϊ����״̬
					state = START;
					score = 0; //�����ֳ�(�������ݻع�ԭʼ)
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					break;
				}
			}
			/** ��д����Ƴ��¼� */
			public void mouseExited(MouseEvent e){
				if(state==RUNNING){ //����״̬ʱ
					state=PAUSE;    //��Ϊ��ͣ״̬
				}
			}
			/** ��д��������¼� */
			public void mouseEntered(MouseEvent e){
				if(state==PAUSE){  //��ͣ״̬ʱ
					state=RUNNING; //��Ϊ����״̬
				}
			}
		};
		this.addMouseListener(l); //�����������¼�
		this.addMouseMotionListener(l); //������껬���¼�
		
		Timer timer = new Timer(); //��ʱ������
		int intervel = 10; //��ʱ���(�Ժ���Ϊ��λ)
		timer.schedule(new TimerTask(){
			public void run(){ //10����-��ʱ�ɵ��Ǹ���
				if(state==RUNNING){ //����״̬�²���
					enterAction(); //�����볡
					stepAction(); //��������һ��
					shootAction(); //�ӵ��볡(Ӣ�ۻ������ӵ�)
					outOfBoundsAction(); //ɾ��Խ��ĵ��˺��ӵ�
					bangAction(); //�ӵ�����˵���ײ
					checkGameOverAction(); //�����Ϸ�Ƿ����
				}
				repaint(); //�ػ�(����paint())
			}
		},intervel,intervel);
	}
	
	/** ��дpaint() g:���� */
	public void paint(Graphics g){
		g.drawImage(background,0,0,null); //������ͼ
		paintHero(g); //��Ӣ�ۻ�����
		paintFlyingObjects(g); //������(�л�+С�۷�)����
		paintBullets(g); //���ӵ�����
		paintScoreAndLife(g); //���ֺͻ���
		paintState(g); //��״̬
	}
	/** ��Ӣ�ۻ����� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null); //��Ӣ�ۻ�
	}
	/** ������(�л�+С�۷�)���� */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){ //������������
			FlyingObject f = flyings[i]; //��ȡÿһ������
			g.drawImage(f.image,f.x,f.y,null); //������
		}
	}
	/** ���ӵ����� */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //�����ӵ�����
			Bullet b = bullets[i]; //��ȡÿһ���ӵ�
			g.drawImage(b.image,b.x,b.y,null); //���ӵ�
		}
	}
	/** ���ֺͻ��� */
	public void paintScoreAndLife(Graphics g){
		g.setColor(new Color(0xFF0000)); //������ɫ(����)
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24)); //����������ʽ(����:SANS_SERIF ��ʽ:BOLD�Ӵ� �ֺ�:24)
		g.drawString("SCORE: "+score,10,25); //����
		g.drawString("LIFE: "+hero.getLife(),10,45); //����
	}
	/** ��״̬ */
	public void paintState(Graphics g){
		switch(state){ //���ݵ�ǰ״̬����ͬ��ͼ
		case START: //����״̬ʱ������ͼ
			g.drawImage(start,0,0,null);
			break;
		case PAUSE: //��ͣ״̬ʱ����ͣͼ
			g.drawImage(pause,0,0,null);
			break;
		case GAME_OVER: //��Ϸ����״̬ʱ����Ϸ����ͼ
			g.drawImage(gameover,0,0,null);
			break;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("fly"); //���ڶ���
		ShootGame game = new ShootGame(); //������
		frame.add(game); //�������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT); //���ô��ڴ�С
		frame.setAlwaysOnTop(true); //����һֱ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����Ĭ�Ϲرղ���(���ڹر����˳�)
		frame.setLocationRelativeTo(null); //���ô��ڳ�ʼλ��(������ʾ)
		frame.setVisible(true); //1.���ô��ڿɼ�  2.�������paint()
		
		game.action(); //���������ִ��
	}
}












