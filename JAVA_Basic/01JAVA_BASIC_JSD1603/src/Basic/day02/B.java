package Basic.day02;

public class B extends A{
    public void Name(){
        System.out.println(super.getName());
    }
    public void Age(){
        System.out.println(super.age);
    }

    public static void main(String[] args) {
        B b = new B();
        b.Name();
        b.Age();
    }
}
