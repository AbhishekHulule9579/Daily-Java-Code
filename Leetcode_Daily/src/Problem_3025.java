import java.util.*;

public class Problem_3025 {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        // Sort points by x increasing, if equal then y decreasing
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            int maxy = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];

                // Condition: A must be upper-left of B
                if (y2 > y1) continue;

                // No other point inside rectangle check
                if (y2 > maxy) {
                    ans++;
                    maxy = y2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem_3025 sol = new Problem_3025();

        // Example 2 input
        int[][] points = {
                {6, 2},
                {4, 4},
                {2, 6}
        };

        int result = sol.numberOfPairs(points);
        System.out.println("Output: " + result);  // Expected: 2
    }
}