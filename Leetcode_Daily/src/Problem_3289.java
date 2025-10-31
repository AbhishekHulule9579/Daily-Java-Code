import java.util.*;

public class Problem_3289 {

    static class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            HashSet<Integer> hset = new HashSet<>();
            int ans[] = new int[2];
            int index = 0;
            for (int num : nums) {
                if (hset.contains(num)) {
                    ans[index++] = num;
                }
                hset.add(num);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int[] result = sol.getSneakyNumbers(nums);

        System.out.println("Sneaky numbers (appearing twice): " + Arrays.toString(result));
        sc.close();
    }
}
