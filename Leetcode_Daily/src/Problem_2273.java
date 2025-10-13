import java.util.*;

public class Problem_2273 {

    static class Solution {
        public List<String> removeAnagrams(String[] words) {
            List<String> ans = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                int j = i + 1;
                while (j < words.length) {
                    if (!isAnagram(words[i], words[j])) {
                        break;
                    }
                    j++;
                }
                ans.add(words[i]);
                i = j - 1;
            }

            return ans;
        }

        boolean isAnagram(String a, String b) {
            if (a.length() != b.length()) return false;

            char[] arr1 = a.toCharArray();
            char[] arr2 = b.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            return Arrays.equals(arr1, arr2);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};

        List<String> result = sol.removeAnagrams(words);
        System.out.println("Result after removing anagrams: " + result);
    }
}
