import java.util.*;
import java.io.*;

public class Problem_976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int largestParameter = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] + nums[i+1] > nums[i+2]) {
                largestParameter = Math.max(largestParameter, nums[i] + nums[i+1] + nums[i+2]);
            }
        }
        return largestParameter;
    }

    public static void main(String[] args) throws Exception {
        // Input: single line, space-separated integers
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split("\\s+");
        int[] nums = new int[s.length];
        for(int i = 0; i < s.length; i++) nums[i] = Integer.parseInt(s[i]);
        System.out.println(new Problem_976().largestPerimeter(nums));
    }
}
