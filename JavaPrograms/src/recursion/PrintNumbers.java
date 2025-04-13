package recursion;

public class PrintNumbers {

    public static void printNumbers(int n) {
        // Base case: if n <= 0, stop the recursion
        if (n <= 0) {
            return;
        }

        // Recursive case: first print the numbers from 1 to n-1
        printNumbers(n - 1);

        // Then print the current number n
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10; // Change n to the desired value
        printNumbers(n); // Output: 1, 2, 3, ..., n
    }
}

