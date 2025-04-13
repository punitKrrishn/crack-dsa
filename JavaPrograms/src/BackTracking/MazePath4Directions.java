package BackTracking;

public class MazePath4Directions {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        boolean[][] visited = new boolean[rows][cols];
        maze4Dir(0, 0, rows - 1, cols - 1, "", visited);  // Starting from (0,0) to (2,2) in a 3x3 grid
    }

    private static void maze4Dir(int sr, int sc, int er, int ec, String str, boolean[][] visited) {

        // Check if out of bounds or already visited
        if (sr < 0 || sc < 0 || sr > er || sc > ec || visited[sr][sc]) {
            return;
        }

        // If we reach the destination, print the path
        if (sr == er && sc == ec) {
            System.out.println(str);
            return;
        }

        // Mark the current cell as visited
        visited[sr][sc] = true;

        // Move Left
        maze4Dir(sr, sc - 1, er, ec, str + "L", visited);

        // Move Right
        maze4Dir(sr, sc + 1, er, ec, str + "R", visited);

        // Move Up
        maze4Dir(sr - 1, sc, er, ec, str + "U", visited);

        // Move Down
        maze4Dir(sr + 1, sc, er, ec, str + "D", visited);

        // Backtrack and unmark the current cell as visited
        visited[sr][sc] = false;
    }
}
