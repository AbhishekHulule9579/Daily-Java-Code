import java.util.*;

public class Problem_3495 {
    static class Solution {
        public long minOperations(int[][] queries) {
            long result = 0;
            for (int[] q : queries) {
                long l = q[0], r = q[1], sum = 0, operation = 0;

                for (long range = 1; range <= r; range *= 4) {
                    long sr = Math.max(range, l);
                    long er = Math.min(r, range * 4 - 1);

                    sum += Math.max(0L, ++operation * (er - sr + 1));
                }
                result += (sum + 1) / 2;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] queries = {
                {1, 2},
                {2,4}
        };

        long ans = sol.minOperations(queries);
        System.out.println("Result: " + ans);
    }
}
/*
* Leetcode Problem 3495
* */