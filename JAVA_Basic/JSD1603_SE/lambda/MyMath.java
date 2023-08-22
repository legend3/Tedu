package lambda;

/*
 * Created by 颜群
 */
@FunctionalInterface
public interface MyMath<Integer> {//限定<函数的输入参数的类型, 函数的返回值的类型>
    int add(int n1,int n2);
}
