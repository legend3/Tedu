package Oop.day06;

public class staticInnerClassDemo {
    public static void main(String[] args) {
        Leader leader = new Leader();
        Leader.Staff staff = new Leader.Staff("油漆工");
        staff.showLeader();
        staff.run();
    }
}
class Leader {
    private static String lname;
    private int age;

    public static void do01() {
        System.out.println("领导的静态工作");
    }
    public void do02() {
        System.out.println("领导的普通工作");
    }

    static class Staff extends Thread {//静态内部类
        private String name;
        private int age;

        public Staff(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("通过内部类是外部类实现了多继承...");
        }

        public void showLeader() {//丰富了Leader的lname属性
            lname = "大boss";
            System.out.println("领导的名字：" + lname);
            System.out.println("员工自己的名字：" + name);
            new Leader().do02();//调用外部类的非方法，要用外部类的实例调.
            do01();//调用外部类的静态方法
        }
    }
}