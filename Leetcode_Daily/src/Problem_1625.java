import java.util.*;

public class Problem_1625 {

    static class Solution {
        String result;

        public String findLexSmallestString(String s, int a, int b) {
            result = s;
            helper(s, a, b, new HashSet<>());
            return result;
        }

        void helper(String s, int a, int b, HashSet<String> seen) {
            if (seen.add(s)) {
                if (result.compareTo(s) > 0) {
                    result = s;
                }

                char[] chars = s.toCharArray();
                for (int i = 1; i < chars.length; i += 2) {
                    chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
                }
                helper(String.valueOf(chars), a, b, seen);

                helper(s.substring(b) + s.substring(0, b), a, b, seen);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        String s1 = "5525";
        int a1 = 9, b1 = 2;
        System.out.println("Example 1 Output: " + sol.findLexSmallestString(s1, a1, b1));
        // Expected: "2050"

        String s2 = "74";
        int a2 = 5, b2 = 1;
        System.out.println("Example 2 Output: " + sol.findLexSmallestString(s2, a2, b2));
        // Expected: "24"

        String s3 = "43987654";
        int a3 = 7, b3 = 3;
        System.out.println("Example 3 Output: " + sol.findLexSmallestString(s3, a3, b3));
        // Expected: "00553311"
    }
}
