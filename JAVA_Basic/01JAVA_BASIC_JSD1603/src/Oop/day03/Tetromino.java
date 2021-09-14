package Oop.day03;
//父类
public class Tetromino {
	Cell[] cells; //格子数组
//	private int num;
	Tetromino(){
		cells = new Cell[4];
//		this.num = num;
	}
	
	void drop(){
		for(int i=0;i<this.cells.length;i++){
			this.cells[i].row++;
		}
	}
	void moveLeft(){
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){ //输出每个格子的行列号
		for(int i=0;i<this.cells.length;i++){
			String str = this.cells[i].getCellInfo();
			System.out.println(str);
		}
	}

}





