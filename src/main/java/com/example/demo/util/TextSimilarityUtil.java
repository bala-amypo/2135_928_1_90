package com.example.demo.util;

import java.util.HashSet;
import java.util.Set;

public class TextSimilarityUtil {

    /**
     * Calculates simple text similarity between two strings.
     * Returns a value between 0.0 and 1.0
     */
    public static double similarity(String text1, String text2) {

        if (text1 == null || text2 == null) {
            return 0.0;
        }

        String[] words1 = text1.toLowerCase().split("\\s+");
        String[] words2 = text2.toLowerCase().split("\\s+");

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (String word : words1) {
            set1.add(word);
        }

        for (String word : words2) {
            set2.add(word);
        }

        set1.retainAll(set2);

        if (set1.isEmpty()) {
            return 0.0;
        }

        return (double) set1.size() /
                Math.max(words1.length, words2.length);
    }
}
