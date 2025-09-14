import java.util.*;

public class Problem_966 {
    public static void main(String[] args) {
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        String[] result = spellchecker(wordlist, queries);

        System.out.println(Arrays.toString(result));
        // Output: [kite, KiTe, KiTe, Hare, hare, "", "", KiTe, "", KiTe]
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);
            String lower = word.toLowerCase();
            lowerMap.putIfAbsent(lower, word);
            String devowelled = devowel(lower);
            vowelMap.putIfAbsent(devowelled, word);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactWords.contains(query)) {
                res[i] = query;
            } else {
                String lowerQ = query.toLowerCase();
                if (lowerMap.containsKey(lowerQ)) {
                    res[i] = lowerMap.get(lowerQ);
                } else {
                    String devowelQ = devowel(lowerQ);
                    res[i] = vowelMap.getOrDefault(devowelQ, "");
                }
            }
        }
        return res;
    }

    private static String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(isVowel(c) ? '*' : c);
        }
        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
