import java.util.*;

public class Problem_3349 {

    static class Solution {
        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            int n = nums.size();
            if (k == 1)
                return true;

            boolean[] temp = new boolean[n];
            int left = 0, right = 1;

            while (right < n) {
                // Expand the increasing window
                while (right < n && nums.get(right) > nums.get(right - 1)) {
                    if (right - left + 1 == k) {
                        temp[right - k + 1] = true; // Mark the start of valid window
                        left++; // Slide window
                    }
                    right++;
                }
                // Reset when sequence breaks
                left = right;
                right++;
            }

            // Check two increasing subarrays of size k apart
            for (int i = k; i < n; i++) {
                if (temp[i] && temp[i - k])
                    return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int k1 = 3;
        System.out.println("Example 1: " + sol.hasIncreasingSubarrays(nums1, k1)); // true

        // Example 2
        List<Integer> nums2 = Arrays.asList(1, 2, 1, 2, 3, 4);
        int k2 = 2;
        System.out.println("Example 2: " + sol.hasIncreasingSubarrays(nums2, k2)); // true

        // Example 3
        List<Integer> nums3 = Arrays.asList(5, 4, 3, 2, 1);
        int k3 = 2;
        System.out.println("Example 3: " + sol.hasIncreasingSubarrays(nums3, k3)); // false
    }
}
