import java.util.*;

public class Problem_778 {

    static class Solution {
        int dirs[][] = {{-1,0}, {0,-1}, {1,0},{0,1}};

        public int swimInWater(int[][] grid) {
            int n = grid.length;
            boolean visited[][] = new boolean[n][n];

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

            pq.offer(new int[]{0, 0, grid[0][0]});
            visited[0][0] = true;

            while (!pq.isEmpty()) {
                int cell[] = pq.poll();
                int cx = cell[0], cy = cell[1], h = cell[2];

                if (cx == n - 1 && cy == n - 1) {
                    return h;
                }

                for (int dir[] : dirs) {
                    int x = cx + dir[0];
                    int y = cy + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) continue;

                    int height = grid[x][y];
                    int newHeight = Math.max(h, height);
                    visited[x][y] = true;

                    pq.offer(new int[]{x, y, newHeight});
                }
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of grid (n x n):");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];
        System.out.println("Enter the grid values:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution solver = new Solution();
        int result = solver.swimInWater(grid);
        System.out.println("Minimum time to reach bottom-right: " + result);
    }
}
