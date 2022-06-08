package effective_java.Ten01;

public enum Color {
    RED("红色"), YELLOW("黄色"), GREEN("绿色"), BLACK("黑色");

    private String name;

    Color(String name) {
        this.name = name;
//        System.out.println("......");//实例化时，所有子类都是被创建，所以都打印一次
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    //(实例的)抽象方法
}
