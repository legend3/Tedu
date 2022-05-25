package effective_java.Four;

// Noninstantiable utility class
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {//限制UtilityClass被实例化创建，不一定要创建抽象类！
        throw new AssertionError();
    }
//... // Remainder omitted
}
