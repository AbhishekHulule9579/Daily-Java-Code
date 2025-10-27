import java.util.*;

public class Problem_2125 {

    static class Solution {
        public int numberOfBeams(String[] bank) {
            int count = 0;
            int prev = 0;

            for (String floor : bank) {
                int curr = 0; // total security devices
                for (int i = 0; i < floor.length(); i++) {
                    if (floor.charAt(i) == '1') {
                        curr++;
                    }
                }
                count += curr * prev;
                if (curr > 0) prev = curr;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows in the bank: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bank = new String[n];
        System.out.println("Enter each row (string of 0s and 1s):");
        for (int i = 0; i < n; i++) {
            bank[i] = sc.nextLine();
        }

        Solution sol = new Solution();
        int result = sol.numberOfBeams(bank);
        System.out.println("Total number of laser beams: " + result);

        sc.close();
    }
}
