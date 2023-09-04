package Effective_Java.Two;


import org.junit.Test;

public class TestCases {
    @Test
    public void test01() {
        //通过内部静态类Builder设置(构造方法)参数，通过build方法创建NutritionFacts实例！
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    }
    @Test
    public void test02() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();
        System.out.println(nyPizza);
        System.out.println(calzone);
    }
}
