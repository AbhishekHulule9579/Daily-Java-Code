import java.util.*;

public class Problem_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[201][201];
        return helper(triangle, 0, 0, dp);
    }

    private int helper(List<List<Integer>> triangle, int rowIndex, int cRowIndex, Integer[][] dp) {
        if (rowIndex == triangle.size()) {
            return 0;
        }

        if (dp[rowIndex][cRowIndex] != null) {
            return dp[rowIndex][cRowIndex];
        }

        int result = triangle.get(rowIndex).get(cRowIndex) +
                Math.min(helper(triangle, rowIndex + 1, cRowIndex, dp),
                        helper(triangle, rowIndex + 1, cRowIndex + 1, dp));

        dp[rowIndex][cRowIndex] = result;

        return dp[rowIndex][cRowIndex];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Problem_120 solution = new Problem_120();

        System.out.print("Enter number of rows in triangle: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> triangle = new ArrayList<>();

        System.out.println("Enter the triangle values row by row (space-separated):");
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            String[] nums = sc.nextLine().trim().split("\\s+");
            for (String num : nums) {
                row.add(Integer.parseInt(num));
            }
            triangle.add(row);
        }

        int result = solution.minimumTotal(triangle);
        System.out.println("Minimum path sum: " + result);
        sc.close();
    }
}
