package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        TowerOfHanoi tower = new TowerOfHanoi();
        int n = 3; // Number of disks
        int from = 1; // Source pole
        int to = 3; // Target pole
        int aux = 2; // Auxiliary pole

        int moves = tower.toh(n, from, to, aux);
        System.out.println("Total moves: " + moves);
    }

    // Method to solve Tower of Hanoi
    public int toh(int n, int from, int to, int aux) {
        // Base case: no disk to move
        if (n == 0) {
            return 0;
        }

        int count = 0;

        // Step 1: Move n-1 disks from 'from' to 'aux' using 'to' as auxiliary
        count += toh(n - 1, from, aux, to);

        // Step 2: Move the nth disk from 'from' to 'to'
        System.out.println("Move disk " + n + " from pole " + from + " to pole " + to);
        count++; // One move for this disk

        // Step 3: Move the n-1 disks from 'aux' to 'to' using 'from' as auxiliary
        count += toh(n - 1, aux, to, from);

        return count;
    }
}
