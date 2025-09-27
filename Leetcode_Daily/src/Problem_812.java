import java.util.*;

public class Problem_812 {
    static class Solution {
        public double largestTriangleArea(int[][] points) {
            double max = 0.0;
            int n = points.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int[] A = points[i], B = points[j], C = points[k];
                        double area = Math.abs(
                                (B[0] - A[0]) * (C[1] - A[1]) -
                                        (C[0] - A[0]) * (B[1] - A[1])
                        ) / 2.0;
                        if (area > max) max = area;
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {

        int[][] points1 = { {0,0}, {0,1}, {1,0}, {0,2}, {2,0} };
        System.out.println(new Solution().largestTriangleArea(points1));

        int[][] points2 = { {1,0}, {0,0}, {0,1} };
        System.out.println(new Solution().largestTriangleArea(points2));

        int[][] points3 = { {0,0}, {1,1}, {2,2}, {3,3} };
        System.out.println(new Solution().largestTriangleArea(points3));
    }
}
