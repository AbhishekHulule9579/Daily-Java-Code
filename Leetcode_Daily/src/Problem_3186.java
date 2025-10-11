import java.util.*;

public class Problem_3186 {

    static class Solution {
        public long maximumTotalDamage(int[] power) {

            Map<Integer, Long> count = new HashMap<>();
            for (int p : power) {
                count.put(p, count.getOrDefault(p, 0L) + 1);
            }

            List<Integer> keys = new ArrayList<>(count.keySet());
            Collections.sort(keys); // O(n log n)

            int n = keys.size();
            long[] dp = new long[n];

            dp[0] = count.get(keys.get(0)) * keys.get(0);

            for (int i = 1; i < n; i++) {
                long skip = dp[i - 1];
                int curr = keys.get(i);
                long take = count.get(curr) * curr;

                int j = i - 1;
                while (j >= 0 && keys.get(j) >= curr - 2) j--;

                if (j >= 0)
                    take += dp[j];

                dp[i] = Math.max(take, skip);
            }

            return dp[n - 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in power array:");
        int n = sc.nextInt();
        int[] power = new int[n];

        System.out.println("Enter elements of power array:");
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }

        Solution solver = new Solution();
        long result = solver.maximumTotalDamage(power);
        System.out.println("Maximum Total Damage: " + result);
    }
}
