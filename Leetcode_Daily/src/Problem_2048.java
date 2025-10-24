import java.util.*;

public class Problem_2048 {

    static class Solution {
        public int nextBeautifulNumber(int n) {
            while (true) {
                n = n + 1;
                if (isBeautiful(n)) {
                    return n;
                }
            }
        }

        private boolean isBeautiful(int n) {
            Map<Integer, Integer> freq = new HashMap<>();

            int temp = n;
            while (temp > 0) {
                int r = temp % 10;
                freq.put(r, freq.getOrDefault(r, 0) + 1);
                temp = temp / 10;
            }

            for (int k : freq.keySet()) {
                if (k != freq.get(k)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int result = sol.nextBeautifulNumber(n);
        System.out.println("Next beautiful number after " + n + " is: " + result);

        sc.close();
    }
}
