package BackTracking;

public class MazePathWithObstacles {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int[][] maze = {
                {0, 0, 0},  // Free space in all cells
                {0, 1, 0},  // Obstacle in the middle
                {0, 0, 0}   // Free space in all cells
        };

        // Starting from (0,0) to (2,2)
        maze4Dir(0, 0, rows - 1, cols - 1, "", maze);
    }

    private static void maze4Dir(int sr, int sc, int er, int ec, String str, int[][] maze) {

        // Check if out of bounds or the current cell has an obstacle (1) or is visited (marked as 2)
        if (sr < 0 || sc < 0 || sr > er || sc > ec || maze[sr][sc] == 1) {
            return;
        }

        // If we reach the destination, print the path
        if (sr == er && sc == ec) {
            System.out.println(str);
            return;
        }

        // Mark the current cell as visited (2)
        maze[sr][sc] = 2;

        // Move Left
        maze4Dir(sr, sc - 1, er, ec, str + "L", maze);

        // Move Right
        maze4Dir(sr, sc + 1, er, ec, str + "R", maze);

        // Move Up
        maze4Dir(sr - 1, sc, er, ec, str + "U", maze);

        // Move Down
        maze4Dir(sr + 1, sc, er, ec, str + "D", maze);

        // Backtrack: unmark the current cell as visited (set it back to 0)
        maze[sr][sc] = 0;
    }
}
