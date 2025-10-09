import java.util.*;

public class Problem_3494 {

    static class Solution {
        public long minTime(int[] skill, int[] mana) {
            int[] users = skill;
            int[] products = mana;

            int m = products.length;
            int n = users.length;

            long[] times = new long[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long t = (long) products[i] * users[j];

                    if (j == 0) {
                        times[0] = times[0] + t;
                    } else {
                        times[j] = Math.max(times[j], times[j - 1]) + t;
                    }
                }

                for (int j = n - 2; j >= 0; j--) {
                    times[j] = times[j + 1] - (long) products[i] * users[j + 1];
                }
            }

            return times[n - 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in skill array:");
        int n = sc.nextInt();
        int[] skill = new int[n];
        System.out.println("Enter elements of skill array:");
        for (int i = 0; i < n; i++) {
            skill[i] = sc.nextInt();
        }

        System.out.println("Enter number of elements in mana array:");
        int m = sc.nextInt();
        int[] mana = new int[m];
        System.out.println("Enter elements of mana array:");
        for (int i = 0; i < m; i++) {
            mana[i] = sc.nextInt();
        }

        Solution solver = new Solution();
        long result = solver.minTime(skill, mana);
        System.out.println("Minimum total time: " + result);
    }
}
