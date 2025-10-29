import java.util.*;

public class Problem_3370 {

    static class Solution {
        public int smallestNumber(int n) {
            int msb = Integer.highestOneBit(n);
            return (msb << 1) - 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.smallestNumber(n);
        System.out.println("Smallest number with all bits set below highest bit: " + result);

        sc.close();
    }
}
