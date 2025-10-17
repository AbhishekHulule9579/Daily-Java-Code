import java.util.*;

public class Problem_3003 {

    static class Solution {
        String s;
        int k;
        Map<Long, Integer> memo = new HashMap<>();

        public int maxPartitionsAfterOperations(String s, int k) {
            this.k = k;
            this.s = s;
            memo.clear();
            return helper(0, 0, 1);
        }

        private int helper(int index, int bitmask, int changeallowed) {
            if (index == s.length()) return 1;

            long key = ((long) index << 27) | ((long) bitmask << 1) | changeallowed;
            if (memo.containsKey(key)) return memo.get(key);

            int pos = s.charAt(index) - 'a';
            int newbitmask = bitmask | (1 << pos);
            int ans;

            if (Integer.bitCount(newbitmask) > k)
                ans = 1 + helper(index + 1, (1 << pos), changeallowed);
            else
                ans = helper(index + 1, newbitmask, changeallowed);

            if (changeallowed == 1) {
                for (int i = 0; i < 26; i++) {
                    int newmask = bitmask | (1 << i);
                    if (Integer.bitCount(newmask) > k)
                        ans = Math.max(ans, 1 + helper(index + 1, (1 << i), 0));
                    else
                        ans = Math.max(ans, helper(index + 1, newmask, 0));
                }
            }

            memo.put(key, ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        String s1 = "accca";
        int k1 = 2;
        System.out.println("Example 1: " + sol.maxPartitionsAfterOperations(s1, k1)); // Output: 3

        String s2 = "aabaab";
        int k2 = 3;
        System.out.println("Example 2: " + sol.maxPartitionsAfterOperations(s2, k2)); // Output: 2

        String s3 = "xxyz";
        int k3 = 1;
        System.out.println("Example 3: " + sol.maxPartitionsAfterOperations(s3, k3)); // Output: 3
    }
}
