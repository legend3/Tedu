package effective_java.Five;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class SpellChecker {
    //dictionary是final属性，(创建对象时)必需被赋值且只能被赋值一次(构造方法中完成赋值！)
    private final Lexicon dictionary;

    //构造方法
    public SpellChecker(Lexicon dictionary) {//依赖注入！
        this.dictionary = dictionary;//初始化final变量进行赋值
    }
    //静态工厂方法
    public static SpellChecker getSpellChecker(Supplier<? extends Lexicon> supplier) {//可重复调用(保证只创建一次实例)
        //Supplier以允许客户端传入工厂，创建指定类型的任何子类型
        return new SpellChecker(supplier.get());
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
