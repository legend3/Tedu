package Oop.day02;
//格子类的测试类
public class CellTest {
	public static void main(String[] args) {
		Cell c1 = new Cell(); //调无参
		Cell c2 = new Cell(3); //调1个参数的
		Cell c3 = new Cell(2,5); //调2个参数的
		
		
		
		/*
		Cell c = new Cell();
		c.drop(); //下落1格
		c.drop(3); //下落3格
		c.moveLeft(); //左移1格
		c.moveLeft(2); //左移2格
		*/
	}

	//打墙+打格
	public static void printWall(Cell cc){
		for(int i=0;i<20;i++){ //行号
			for(int j=0;j<10;j++){ //列号
				if(i==cc.row && j==cc.col){ //行列匹配
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println(); //换行
		}
	}
}














