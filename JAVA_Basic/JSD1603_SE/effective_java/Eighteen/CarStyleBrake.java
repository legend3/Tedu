package effective_java.Eighteen;

/**
 * 现有类
 */
public class CarStyleBrake implements IBrakeBehavior{
    @Override
    public void brake() {
        System.out.println("汽车刹车");
    }
}
