import java.util.Scanner;

public class Problem_3227 {
    static class Solution {
        public boolean doesAliceWin(String s) {
            String vowels = "aeiou";
            int vcount = 0;

            for (char c : s.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    vcount += 1;
                }
            }
            return vcount > 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        Solution sol = new Solution();
        boolean result = sol.doesAliceWin(s);

        System.out.println(result);
        sc.close();
    }
}
