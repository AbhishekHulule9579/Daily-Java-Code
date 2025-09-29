import java.util.*;

public class Problem_1039 {

    static class Solution {
        public int minScoreTriangulation(int[] values) {
            int n = values.length;
            Integer[][] dp = new Integer[n][n];
            return helper(values, 0, n - 1, dp);
        }

        private int helper(int[] values, int i, int j, Integer[][] dp) {
            if (i + 1 == j) {
                return 0;
            }
            if (dp[i][j] != null) {
                return dp[i][j];
            }
            int ans = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                ans = Math.min(ans,
                        values[i] * values[j] * values[k]
                                + helper(values, i, k, dp)
                                + helper(values, k, j, dp));
            }
            dp[i][j] = ans;
            return dp[i][j];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            if (!sc.hasNextInt()) {
                System.out.println("0");
                return;
            }
            int n = sc.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = sc.nextInt();
            }
            Solution sol = new Solution();
            int result = sol.minScoreTriangulation(values);
            System.out.println(result);
        } finally {
            sc.close();
        }
    }
}
