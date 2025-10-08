import java.util.*;

public class Problem_2300 {

    static class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int n = spells.length;
            int ans[] = new int[n];

            for (int i = 0; i < n; i++) {
                int index = getMinPotions(spells[i], potions, success);
                ans[i] = potions.length - index;
            }

            return ans;
        }

        int getMinPotions(int spell, int[] potions, long success) {
            int left = 0, right = potions.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) potions[mid] * spell >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of spells:");
        int n = sc.nextInt();
        int[] spells = new int[n];
        System.out.println("Enter spells array:");
        for (int i = 0; i < n; i++) {
            spells[i] = sc.nextInt();
        }

        System.out.println("Enter number of potions:");
        int m = sc.nextInt();
        int[] potions = new int[m];
        System.out.println("Enter potions array:");
        for (int i = 0; i < m; i++) {
            potions[i] = sc.nextInt();
        }

        System.out.println("Enter success threshold:");
        long success = sc.nextLong();

        Solution solver = new Solution();
        int[] result = solver.successfulPairs(spells, potions, success);

        System.out.println("Successful pairs count for each spell:");
        System.out.println(Arrays.toString(result));
    }
}
