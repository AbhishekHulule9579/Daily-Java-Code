import java.util.*;

public class Problem_3346 {

    static class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            Arrays.sort(nums);

            Map<Integer, Integer> freq = new HashMap<>();
            for (int n : nums) {
                freq.put(n, freq.getOrDefault(n, 0) + 1);
            }

            int maxNum = nums[nums.length - 1];
            int ans = 0;

            for (int target = 1; target <= maxNum; target++) {
                ans = Math.max(ans, maximumFreq(target, nums, freq, k, numOperations));
            }

            return ans;
        }

        private int maximumFreq(int target, int[] nums, Map<Integer, Integer> freq, int k, int numOperations) {
            int left = getIndex(nums, target - k);
            int right = getIndex(nums, target + k + 1);
            int operations = right - left - freq.getOrDefault(target, 0);

            return Math.min(operations, numOperations) + freq.getOrDefault(target, 0);
        }

        private int getIndex(int[] nums, int target) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test case
        int[] nums1 = {1, 4, 5, 6, 8, 9};
        int k1 = 2;
        int numOperations1 = 3;
        System.out.println("Example 1 Output: " + sol.maxFrequency(nums1, k1, numOperations1));

        int[] nums2 = {3, 9, 6, 12};
        int k2 = 3;
        int numOperations2 = 2;
        System.out.println("Example 2 Output: " + sol.maxFrequency(nums2, k2, numOperations2));

        int[] nums3 = {1, 2, 2, 3, 3, 3};
        int k3 = 1;
        int numOperations3 = 2;
        System.out.println("Example 3 Output: " + sol.maxFrequency(nums3, k3, numOperations3));
    }
}
