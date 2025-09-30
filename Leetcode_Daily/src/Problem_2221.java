import java.util.*;

public class Problem_2221 {

    static class Solution {
        public int triangularSum(int[] nums) {
            int n = nums.length;
            for (int len = n; len > 1; len--) {
                for (int i = 0; i < len - 1; i++) {
                    nums[i] = (nums[i] + nums[i + 1]) % 10;
                }
            }
            return nums[0];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            sc.close();

    }
}
