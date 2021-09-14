package Oop.day02;

public class ConstructorMethodDemo {
    private int row;
    private int col;

    /**
     * 多参构造器
     * @param row
     * @param col
     */
    public ConstructorMethodDemo(int row, int col) {
        this();//多参调无参，被调用的永远要放在第一行
        this.row = row;
        this.col = col;
    }

    /**
     * 单参构造器
     * @param row
     */
    public ConstructorMethodDemo(int row) {
        this(row, row);//单参调多参，被调用的永远要放在第一行
        this.row = row;
        this.col = col;
    }

    /**
     * 无参构造器
     */
    public ConstructorMethodDemo() {
    }

    public static void main(String[] args) {
        ConstructorMethodDemo c = new ConstructorMethodDemo(5);
        System.out.println(c.row + "-" + c.col);

//        ConstructorMethodDemo c2 = new ConstructorMethodDemo(5);

    }
}
