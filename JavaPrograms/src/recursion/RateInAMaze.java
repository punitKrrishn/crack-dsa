package recursion;

public class RateInAMaze {

    public static void main(String[] args) {
        RateInAMaze mazeSolver = new RateInAMaze();

        int[][] grid = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Call the helper function to count all paths
        int totalPaths = mazeSolver.countPaths(grid, 0, 0, visited);

        System.out.println("Total number of paths: " + totalPaths);
    }

    // Function to count all paths from (i, j) to (m-1, n-1)
    public int countPaths(int[][] grid, int i, int j, boolean[][] visited) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        visited[i][j] = true;

        // Explore all four possible directions (right, down, left, up)
        int pathCount = 0;

        // Move right
        pathCount += countPaths(grid, i, j + 1, visited);

        // Move down
        pathCount += countPaths(grid, i + 1, j, visited);

        // Move left
        pathCount += countPaths(grid, i, j - 1, visited);

        // Move up
        pathCount += countPaths(grid, i - 1, j, visited);

        // Backtrack: Unmark this cell as visited for other potential paths
        visited[i][j] = false;

        return pathCount; // Return the total number of valid paths from this point
    }
}
