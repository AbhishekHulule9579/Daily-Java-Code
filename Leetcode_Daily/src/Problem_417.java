import java.util.*;

public class Problem_417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, heights, pacificVisited, rows, cols);
            dfs(i, cols - 1, heights, atlanticVisited, rows, cols);
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, heights, pacificVisited, rows, cols);
            dfs(rows - 1, j, heights, atlanticVisited, rows, cols);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int x, int y, int[][] heights, boolean[][] visited, int rows, int cols) {
        visited[x][y] = true;

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValid(newX, newY, rows, cols) && !visited[newX][newY]
                    && heights[newX][newY] >= heights[x][y]) {
                dfs(newX, newY, heights, visited, rows, cols);
            }
        }
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows and columns:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] heights = new int[rows][cols];
        System.out.println("Enter the heights matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[i][j] = sc.nextInt();
            }
        }

        Problem_417 solver = new Problem_417();
        List<List<Integer>> result = solver.pacificAtlantic(heights);

        System.out.println("Cells where water can flow to both Pacific and Atlantic:");
        for (List<Integer> cell : result) {
            System.out.println(cell.get(0) + " " + cell.get(1));
        }
    }
}
