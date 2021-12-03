package Oop.day06;

public class shixian implements zi{
    private String n;
    public shixian(String num) {
            this.n = num;
    }

    @Override
    public void work() {
        System.out.println("实现子的方法");
    }

    @Override
    public int getAgentNumber() {
        System.out.println("实现子的父接口的方法...");
        return 0;
    }
}
