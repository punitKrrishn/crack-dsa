package BackTracking;

public class MazePath4DirWithoutBoolean {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        char[][] maze = new char[rows][cols];

        // Initialize maze with '.' (unvisited cells)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = '1';
            }
        }

        maze4Dir(0, 0, rows - 1, cols - 1, "", maze);  // Start from (0,0) to (2,2) in a 3x3 grid
    }

    private static void maze4Dir(int sr, int sc, int er, int ec, String str, char[][] maze) {

        // Check if out of bounds or the current cell is visited (represented by 'V')
        if (sr < 0 || sc < 0 || sr > er || sc > ec || maze[sr][sc] == '0') {
            return;
        }

        // If we reach the destination, print the path
        if (sr == er && sc == ec) {
            System.out.println(str);
            return;
        }

        // Mark the current cell as visited by setting it to 'V'
        maze[sr][sc] = '0';

        // Move Left
        maze4Dir(sr, sc - 1, er, ec, str + "L", maze);

        // Move Right
        maze4Dir(sr, sc + 1, er, ec, str + "R", maze);

        // Move Up
        maze4Dir(sr - 1, sc, er, ec, str + "U", maze);

        // Move Down
        maze4Dir(sr + 1, sc, er, ec, str + "D", maze);

        // Backtrack by marking the current cell as unvisited ('1')
        maze[sr][sc] = '1';
    }
}
