package com.example.demo.util;

public class TextSimilarityUtil {

    public static double similarity(String s1, String s2) {
        if (s1 == null || s2 == null) return 0.0;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        return s1.equals(s2) ? 1.0 : 0.5;
    }
}
