import java.util.*;

public class Problem_3147 {

    static class Solution {
        public int maximumEnergy(int[] energy, int k) {
            int max = Integer.MIN_VALUE;
            int n = energy.length;

            for (int i = 0; i < k; i++) {

                int sum = 0;
                for (int j = n - 1; j - i >= 0; j -= k) {
                    sum += energy[j - i];
                    max = Math.max(sum, max);
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in energy array:");
        int n = sc.nextInt();
        int[] energy = new int[n];

        System.out.println("Enter elements of energy array:");
        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }

        System.out.println("Enter value of k:");
        int k = sc.nextInt();

        Solution solver = new Solution();
        int result = solver.maximumEnergy(energy, k);
        System.out.println("Maximum energy: " + result);
    }
}
