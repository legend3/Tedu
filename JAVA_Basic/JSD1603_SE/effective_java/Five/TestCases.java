package effective_java.Five;


import org.junit.Test;

import java.util.Arrays;

public class TestCases {
    @Test
    public void test01() {
        SpellChecker spellChecker = SpellChecker.getSpellChecker(() -> Lexicon.getEnglishDictionary());//构造方法可以指定不同字典
        System.out.println(spellChecker.isVaild(x -> Arrays.stream(spellChecker.suggestions()).anyMatch(y -> x == "Vivian"), "Vivian"));
    }
}
