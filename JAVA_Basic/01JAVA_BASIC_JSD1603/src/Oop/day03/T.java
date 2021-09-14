package Oop.day03;
//T型
public class T extends Tetromino {
//	T(){
//		this(0,0);
//	}
	T(int row,int col){
//		super(); //默认的--调用父类的无参构造方法
		super.cells[0] = new Cell(row,col);// 访问父类的属性
		this.cells[1] = new Cell(row,col+1);// 子类也本就拥有父类的属性
		this.cells[2] = new Cell(row,col+2);
		this.cells[3] = new Cell(row+1,col+1);
	}

	public static void main(String[] args) {
		T t = new T(3,4);
	}
}











