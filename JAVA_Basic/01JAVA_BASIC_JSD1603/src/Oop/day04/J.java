package Oop.day04;
//J型
public class J extends Tetromino {
	J(){
		this(0,0);
	}
	J(int row,int col){
		cells[0] = new Cell(row,col);
		cells[1] = new Cell(row,col+1);
		cells[2] = new Cell(row,col+2);
		cells[3] = new Cell(row+1,col+2);
	}
	void print(){ 
		System.out.println("I am a J:");
		super.print();
	}

	public static void main(String[] args) {
		J j = new J();
		j.print();
	}
}
