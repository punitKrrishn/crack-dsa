package BackTracking;

public class CountMazePathWithObstacles {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int[][] maze = {
                {0, 0, 0},  // Free space in all cells
                {0, 1, 0},  // Obstacle in the middle
                {0, 0, 0}   // Free space in all cells
        };

        // Create a visited matrix to mark visited cells
        boolean[][] visited = new boolean[rows][cols];

        // Starting from (0,0) to (2,2)
        int result = maze4Dir(0, 0, rows - 1, cols - 1, maze, visited);
        System.out.println("Number of paths: " + result);
    }

    private static int maze4Dir(int sr, int sc, int er, int ec, int[][] maze, boolean[][] visited) {
        // Base case: if out of bounds, or the current cell has an obstacle (1), or already visited
        if (sr < 0 || sc < 0 || sr > er || sc > ec || maze[sr][sc] == 1 || visited[sr][sc]) {
            return 0;
        }

        // If we reach the destination, return 1 (path found)
        if (sr == er && sc == ec) {
            return 1;
        }

        // Mark the current cell as visited
        visited[sr][sc] = true;

        // Initialize the path count to 0
        int pathCount = 0;

        // Move Left
        pathCount += maze4Dir(sr, sc - 1, er, ec, maze, visited);

        // Move Right
        pathCount += maze4Dir(sr, sc + 1, er, ec, maze, visited);

        // Move Up
        pathCount += maze4Dir(sr - 1, sc, er, ec, maze, visited);

        // Move Down
        pathCount += maze4Dir(sr + 1, sc, er, ec, maze, visited);

        // Backtrack: unmark the current cell as visited
        visited[sr][sc] = false;

        // Return the total number of paths found
        return pathCount;
    }
}
