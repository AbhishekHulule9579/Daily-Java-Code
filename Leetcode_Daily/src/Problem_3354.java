import java.util.*;

public class Problem_3354 {

    static class Solution {
        public int countValidSelections(int[] nums) {
            int ans = 0;
            int sum = 0;

            for (int num : nums) {
                sum += num;
            }

            int leftsum = 0;

            for (int i = 0; i < nums.length; i++) {
                leftsum += nums[i];

                if (nums[i] == 0) {
                    if (leftsum == (sum - leftsum)) {
                        ans += 2;
                    } else if (Math.abs(leftsum - (sum - leftsum)) == 1) {
                        ans += 1;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.countValidSelections(nums);
        System.out.println("Count of valid selections: " + result);

        sc.close();
    }
}
