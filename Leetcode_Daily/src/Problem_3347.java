import java.util.*;

public class Problem_3347 {

    static class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {

            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> diff = new HashMap<>();
            List<Integer> points = new ArrayList<>();

            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);

                diff.put(num - k, diff.getOrDefault(num - k, 0) + 1);
                diff.put(num + k + 1, diff.getOrDefault(num + k + 1, 0) - 1);

                points.add(num);
                points.add(num - k);
                points.add(num + k + 1);
            }

            Collections.sort(points);
            int sz = 0;
            for (int i = 0; i < points.size(); i++) {
                if (i == 0 || !points.get(i).equals(points.get(i - 1))) {
                    points.set(sz++, points.get(i));
                }
            }

            int ans = 0, common = 0;
            for (int i = 0; i < sz; i++) {
                int p = points.get(i);
                common += diff.getOrDefault(p, 0);

                int cur = freq.getOrDefault(p, 0);
                int nearby = common - cur;
                int possible = cur + Math.min(nearby, numOperations);

                ans = Math.max(ans, possible);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {1, 4, 5, 6, 8, 9};
        int k1 = 2;
        int numOperations1 = 3;
        System.out.println("Example 1 Output: " + sol.maxFrequency(nums1, k1, numOperations1));

        // Example 2
        int[] nums2 = {3, 9, 6, 12};
        int k2 = 3;
        int numOperations2 = 2;
        System.out.println("Example 2 Output: " + sol.maxFrequency(nums2, k2, numOperations2));

        // Example 3
        int[] nums3 = {1, 2, 2, 3, 3, 3};
        int k3 = 1;
        int numOperations3 = 2;
        System.out.println("Example 3 Output: " + sol.maxFrequency(nums3, k3, numOperations3));
    }
}
