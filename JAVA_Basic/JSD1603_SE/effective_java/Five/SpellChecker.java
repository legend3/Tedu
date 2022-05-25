package effective_java.Five;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SpellChecker {
    //dictionary是final属性，(创建对象时)必需被赋值且只能被赋值一次(构造方法中完成赋值！)
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isVaild(Predicate<String> pre, String word) {
        if(pre.test(word)) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> suggestions(String typo) {
       List<String> list = new ArrayList<String>();
       list.add(typo);
        return list;
    }
}
