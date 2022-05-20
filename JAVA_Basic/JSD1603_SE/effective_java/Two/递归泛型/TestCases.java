package effective_java.Two.递归泛型;

import effective_java.Two.递归泛型.Dog;
import org.testng.annotations.Test;

public class TestCases {
    @Test
    public void test01() {
        Dog dog1 = new Dog("dog1");
        Dog dog2 = new Dog("dog2");

        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");

        dog1.mating(dog1);//通过编译
        cat1.mating(cat1);//通过编译

//        dog2.mating(cat2);//编译错误
//        cat2.mating(dog2);//编译错误
//通过可以避免掉某些时候运行期间类型判断

    }

}
