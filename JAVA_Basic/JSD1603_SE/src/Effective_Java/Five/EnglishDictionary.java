package Effective_Java.Five;

public class EnglishDictionary extends Lexicon {
    private final String[] dictionary = {
                                            "Aaron",
                                            "Vivian"
                                            };

    public String[] getDictionary() {
        return dictionary;
    }

    //单例
    private static EnglishDictionary instance = EnglishDictionary.getInstance();
    public static EnglishDictionary getInstance() {
        return instance;
    }
}
