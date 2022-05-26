package effective_java.Five;

public class Lexicon {
    //实例化子类
    public static Lexicon getEnglishDictionary() {
        return new EnglishDictionary();
    }

    public String[] getDictionary() {
        return getEnglishDictionary().getDictionary();
    }
}
