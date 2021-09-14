package Oop.day02;

/**
 * 复制
 */
public class testClone implements Cloneable{	//被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常)， 该接口为标记接口(不含任何方法)
    int age;

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }

    @Override		//覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象。（native为本地方法)
    public Object clone(){
        testClone t = null;//声明第一testClone引用变量,null的含义为“空”,表示t还没有指向任何对象:
        try{
            t = (testClone)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        testClone t1 = new testClone();
        t1.setage(33);

        testClone t2 = (testClone) t1.clone();//对象t1调用testClone方法clone完成复制t1对象赋值到t2
        System.out.println(t2.getage());
        t2.setage(44);
        System.out.println(t1.age);
        System.out.println(t1 == t2);
    }
}