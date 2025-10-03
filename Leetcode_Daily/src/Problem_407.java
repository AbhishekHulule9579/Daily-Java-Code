import java.util.*;

public class Problem_407 {
    private static class Entry {
        int h, i, j;

        Entry(int h, int i, int j) {
            this.h = h;
            this.i = i;
            this.j = j;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        PriorityQueue<Entry> queue = new PriorityQueue<>((a, b) -> a.h - b.h);
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {
                {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };

        // Add boundary cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isOnBoundary(i, j, rows, cols)) {
                    queue.offer(new Entry(heightMap[i][j], i, j));
                    visited[i][j] = true;
                }
            }
        }

        int maxValue = 0;
        int trapWater = 0;

        while (!queue.isEmpty()) {
            Entry entry = queue.poll();
            maxValue = Math.max(maxValue, entry.h);

            for (int[] dir : directions) {
                int newX = entry.i + dir[0];
                int newY = entry.j + dir[1];

                if (isValid(newX, newY, rows, cols) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    int currentHeight = heightMap[newX][newY];
                    if (currentHeight < maxValue) {
                        trapWater += (maxValue - currentHeight);
                    }
                    queue.offer(new Entry(currentHeight, newX, newY));
                }
            }
        }

        return trapWater;
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    private boolean isOnBoundary(int i, int j, int rows, int cols) {
        return i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows and columns:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] heightMap = new int[rows][cols];
        System.out.println("Enter the height map:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heightMap[i][j] = sc.nextInt();
            }
        }

        Problem_407 solver = new Problem_407();
        int result = solver.trapRainWater(heightMap);
        System.out.println("Trapped water: " + result);
    }
}
