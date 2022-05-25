package effective_java.Five;

public class englishDictionary extends Lexicon {
    private final String[] dictionary = {
                                            "Aaron",
                                            "Vivian"
                                            };

    public String[] getDictionary() {
        return dictionary;
    }

    //单例
    private static englishDictionary instance = englishDictionary.getInstance();
    public static englishDictionary getInstance() {
        return instance;
    }
}
