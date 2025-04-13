package MultiArray;

public class PrintSpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        printMatrix(matrix);  // Print original matrix
        printSpiralMatrix(matrix, matrix.length, matrix[0].length);  // Print matrix in spiral order
    }

    // Method to print any matrix
    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method to print the matrix in spiral order
    private static void printSpiralMatrix(int[][] matrix, int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElements = 0;

        while (totalElements < r * c) {

            // topRow --> leftCol to rightCol
            for (int j = leftCol; j <= rightCol; j++) {
                System.out.print(matrix[topRow][j] + " ");
                totalElements++;
            }
            topRow++;

            // rightCol --> topRow to bottomRow
            for (int i = topRow; i <= bottomRow; i++) {
                System.out.print(matrix[i][rightCol] + " ");
                totalElements++;
            }
            rightCol--;

            if (totalElements >= r * c) break;  // Avoid printing the same element again

            // bottomRow --> rightCol to leftCol
            for (int j = rightCol; j >= leftCol; j--) {
                System.out.print(matrix[bottomRow][j] + " ");
                totalElements++;
            }
            bottomRow--;

            if (totalElements >= r * c) break;  // Avoid printing the same element again

            // leftCol --> bottomRow to topRow
            for (int i = bottomRow; i >= topRow; i--) {
                System.out.print(matrix[i][leftCol] + " ");
                totalElements++;
            }
            leftCol++;
        }
        System.out.println(); // Print a newline after printing the spiral order
    }
}
