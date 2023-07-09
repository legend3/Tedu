package Oop.day06;

/**
 * 局部内部类的示例
 */
public class localityClass {
    public static void main(String[]args){
        School school = new School("新东方", "烹饪", 10000);
        school.show();
    }
}

class School {
    private String schoolName;
    private String buss;
    int studentNum;

    public School(String schoolName, String buss, int studentNum) {
        this.schoolName = schoolName;
        this.buss = buss;
        this.studentNum = studentNum;
    }
    //悬窗
    public void show() {//局部内部类扩充show()
        final double tvMoney = 10000;
        final double netMoney = 20000;

        class AdverTeam {//扩充show方法功能的局部内部类
            String teamName = "xuanchuandui";

            public void tvWork() {//效果：方法中定义方法
                System.out.println("学校: " + schoolName + "  业务内容: " + buss + " 学校人数: " + studentNum + "电视宣传费用: " + tvMoney);
            }
            public void netWork() {//效果：方法中定义方法
                System.out.println("学校: " + schoolName + "  业务内容: " + buss + " 学校人数: " + studentNum + "网络宣传费用: " + netMoney);
            }
        }
        //自动触发调用局部内部类
        new AdverTeam().tvWork();
        new AdverTeam().netWork();
    }
}
