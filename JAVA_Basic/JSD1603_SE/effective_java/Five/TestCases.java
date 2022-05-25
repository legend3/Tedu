package effective_java.Five;

import org.testng.annotations.Test;

public class TestCases {
    @Test
    public void test01() {
        SpellChecker spellChecker = new SpellChecker(EnglishNameGenerator.getInstance());//构造方法可以指定不同字典
        System.out.println(spellChecker.isVaild(x -> x == "Susan", "Susan"));
    }
}
