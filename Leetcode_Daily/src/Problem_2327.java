import java.util.Scanner;

public class Problem_2327 {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 2];
        dp[1] = 1;
        long toShare = 0;

        for (int day = 2; day <= n; ++day) {
            if (day - delay >= 1)
                toShare = (toShare + dp[day - delay]) % MOD;
            if (day - forget >= 1)
                toShare = (toShare - dp[day - forget] + MOD) % MOD;
            dp[day] = toShare;
        }

        long result = 0;
        for (int day = n - forget + 1; day <= n; ++day) {
            result = (result + dp[day]) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n, delay, forget:");
        int n = sc.nextInt();
        int delay = sc.nextInt();
        int forget = sc.nextInt();
        int ans = peopleAwareOfSecret(n, delay, forget);
        System.out.println(ans);
        sc.close();
    }
}
