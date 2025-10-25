import java.util.*;

public class Problem_1716 {

    static class Solution {
        public int totalMoney(int n) {
            int fullWeeks = n / 7;
            int remaining = n % 7;

            // Sum for full weeks using arithmetic progression formula
            int sum = (fullWeeks * (2 * 28 + (fullWeeks - 1) * 7)) / 2;
            // Sum for remaining days in the next week
            sum += (remaining * (2 * (fullWeeks + 1) + (remaining - 1))) / 2;

            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of days (n): ");
        int n = sc.nextInt();

        int result = sol.totalMoney(n);
        System.out.println("Total money after " + n + " days: " + result);

        sc.close();
    }
}
