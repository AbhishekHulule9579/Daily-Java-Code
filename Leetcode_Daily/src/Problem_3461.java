public class Problem_3461 {

    static class Solution {
        public boolean hasSameDigits(String s) {
            while (s.length() > 2) {
                s = helper(s);
            }

            return s.charAt(0) == s.charAt(1);
        }

        String helper(String s) {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < s.length(); i++) {
                int a = Character.getNumericValue(s.charAt(i - 1));
                int b = Character.getNumericValue(s.charAt(i));
                int ch = (a + b) % 10;
                sb.append(ch);
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1 = "1234";
        System.out.println("Input: " + s1 + " → Output: " + sol.hasSameDigits(s1));

        // Example 2
        String s2 = "999";
        System.out.println("Input: " + s2 + " → Output: " + sol.hasSameDigits(s2));

        // Example 3
        String s3 = "5123";
        System.out.println("Input: " + s3 + " → Output: " + sol.hasSameDigits(s3));

        // Example 4
        String s4 = "9876";
        System.out.println("Input: " + s4 + " → Output: " + sol.hasSameDigits(s4));
    }
}
