public class TextSimilarityUtil {
    public static double similarity(String s1, String s2) {
        Set<String> a = new HashSet<>(Arrays.asList(s1.toLowerCase().split(" ")));
        Set<String> b = new HashSet<>(Arrays.asList(s2.toLowerCase().split(" ")));
        a.retainAll(b);
        return (double) a.size() / Math.max(1, b.size());
    }
}