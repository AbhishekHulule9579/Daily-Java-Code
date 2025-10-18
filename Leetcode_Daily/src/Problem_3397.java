import java.util.*;

public class Problem_3397 {

    static class Solution {
        public int maxDistinctElements(int[] nums, int k) {
            Arrays.sort(nums);

            int count = 1;
            int prev = nums[0] - k;

            for (int i = 1; i < nums.length; i++) {
                int min = nums[i] - k;
                int max = nums[i] + k;

                if (min > prev) {
                    count++;
                    prev = min;
                }
                else if (prev < max) {
                    prev = prev + 1;
                    count++;
                }
                else {
                    continue;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        int[] nums1 = {2, 5, 6, 8};
        int k1 = 2;
        System.out.println("Example 1 Output: " + sol.maxDistinctElements(nums1, k1)); // Expected output: 4

        int[] nums2 = {1, 3, 5, 7};
        int k2 = 1;
        System.out.println("Example 2 Output: " + sol.maxDistinctElements(nums2, k2)); // Expected output: 4

        int[] nums3 = {4, 4, 4};
        int k3 = 1;
        System.out.println("Example 3 Output: " + sol.maxDistinctElements(nums3, k3)); // Expected output: 3
    }
}
