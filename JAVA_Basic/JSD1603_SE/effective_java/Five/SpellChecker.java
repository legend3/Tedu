package effective_java.Five;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SpellChecker {
    //dictionary是final属性，(创建对象时)必需被赋值且只能被赋值一次(构造方法中完成赋值！)
    private final Lexicon dictionary;

    //依赖注入！
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;//初始化final变量进行赋值
    }

    public boolean isVaild(Predicate<String> pre, String name) {
        if(pre.test(name)) {
            return true;
        } else {
            return false;
        }
    }

    public String[] suggestions() {
       return dictionary.getDictionary();
    }
}
