import java.util.*;

public class Problem_3350 {

    static class Solution {
        public int maxIncreasingSubarrays(List<Integer> nums) {
            int n = nums.size();
            int max = 1;

            int[] val = new int[n];
            val[0] = 1;

            int in = 1;

            while (in < n) {
                // build lengths of increasing subarrays
                while (in < n && nums.get(in) > nums.get(in - 1)) {
                    val[in] = val[in - 1] + 1;
                    in++;
                }

                if (in < n) {
                    val[in] = 1;
                }

                in++;
            }

            // find the maximum possible length
            for (int i = 0; i < n; i++) {
                int prev = i - val[i];
                if (prev >= 0 && val[prev] >= val[i]) {
                    max = Math.max(val[i], max);
                }
                max = Math.max(max, val[i] / 2);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Example 1: " + sol.maxIncreasingSubarrays(nums1)); // Output: 3

        List<Integer> nums2 = Arrays.asList(1, 2, 1, 2, 3, 4);
        System.out.println("Example 2: " + sol.maxIncreasingSubarrays(nums2)); // Output: 2

        List<Integer> nums3 = Arrays.asList(5, 4, 3, 2, 1);
        System.out.println("Example 3: " + sol.maxIncreasingSubarrays(nums3)); // Output: 1
    }
}
