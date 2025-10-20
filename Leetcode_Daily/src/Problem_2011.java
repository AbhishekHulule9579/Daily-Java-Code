public class Problem_2011 {

    static class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int x = 0;

            for (String op : operations) {
                if (op.indexOf('+') != -1) {
                    x++;
                } else {
                    x--;
                }
            }

            return x;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test case
        String[] operations1 = {"--X", "X++", "X++"};
        System.out.println("Example 1 Output: " + sol.finalValueAfterOperations(operations1));
        // Expected output: 1

        String[] operations2 = {"++X", "++X", "X++"};
        System.out.println("Example 2 Output: " + sol.finalValueAfterOperations(operations2));
        // Expected output: 3

        String[] operations3 = {"X++", "++X", "--X", "X--"};
        System.out.println("Example 3 Output: " + sol.finalValueAfterOperations(operations3));
        // Expected output: 0
    }
}
