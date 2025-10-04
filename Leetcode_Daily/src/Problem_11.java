import java.util.*;

public class Problem_11 {

    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = 0;

        int lp = 0;
        int rp = n - 1;
        while (lp < rp) {
            int width = rp - lp;
            int minHeight = Math.min(height[rp], height[lp]);
            int water = minHeight * width;
            maxWater = Math.max(maxWater, water);

            if (height[lp] < height[rp]) {
                lp += 1;
            } else {
                rp -= 1;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of lines:");
        int n = sc.nextInt();

        int[] height = new int[n];
        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        Problem_11 solver = new Problem_11();
        int result = solver.maxArea(height);
        System.out.println("Maximum water: " + result);
    }
}
