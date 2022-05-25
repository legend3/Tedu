package effective_java.Five;

public class Lexicon {
    //实例化子类
    public static Lexicon getEnglishDictionary() {
        return new englishDictionary();
    }

    public String[] getDictionary() {
        return getEnglishDictionary().getDictionary();
    }
}
