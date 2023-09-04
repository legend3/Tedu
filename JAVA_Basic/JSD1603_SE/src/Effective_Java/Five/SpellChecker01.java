package Effective_Java.Five;

/**
 * 不令人满意: 实现为静态实用工具类
 */

// Inappropriate use of static utility - inflexible & untestable!
public class SpellChecker01 {
//    private static final Lexicon dictionary = ...;

    private SpellChecker01() {} // Noninstantiable
//    public static boolean isValid(String word) { ... }
//    public static List<String> suggestions(String typo) { ... }
}
