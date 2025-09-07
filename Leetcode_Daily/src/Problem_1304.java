// File: Problem_1304.java
import java.util.*;

public class Problem_1304 {
    static class Solution {
        public int[] sumZero(int n) {
            int res[] = new int[n];
            res[0] = -((n) * (n - 1)) / 2;
            for (int i = 1; i < n; i++) {
                res[i] = i;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        int[] ans = sol.sumZero(n);

        System.out.println("Result array: " + Arrays.toString(ans));

        sc.close();
    }
}
/*1304. Find N Unique Integers Sum up to Zero

Given an integer n, return any array containing n unique integers such that they add up to 0.
Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].*/