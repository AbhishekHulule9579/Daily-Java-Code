import java.util.*;

public class Problem_2598 {

    static class Solution {
        public int findSmallestInteger(int[] nums, int value) {
            int[] freq = new int[value];
            for (int num : nums) {
                int rem = ((num % value) + value) % value;
                freq[rem]++;
            }

            int mex = 0;

            while (true) {
                int rem = mex % value;
                if (freq[rem] == 0) break;
                freq[rem]--;
                mex++;
            }

            return mex;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        int[] nums1 = {1, -10, 7, 13, 6, 8};
        int value1 = 5;
        System.out.println("Example 1: " + sol.findSmallestInteger(nums1, value1)); // Output: 4

        int[] nums2 = {1, 2, 3, 4, 5};
        int value2 = 1;
        System.out.println("Example 2: " + sol.findSmallestInteger(nums2, value2)); // Output: 5

        int[] nums3 = {0, 3, 6, 9};
        int value3 = 3;
        System.out.println("Example 3: " + sol.findSmallestInteger(nums3, value3)); // Output: 4
    }
}
