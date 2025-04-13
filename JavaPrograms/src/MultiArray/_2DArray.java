package MultiArray;

public class _2DArray {

    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};

        //printMatrix(arr1);
       // int[][] resultantArray = matrixAddition(arr1,arr2);
       // int[][] resultantArray = matrixMultiplication(arr1,arr2);
        int[][] transposeMatrix = matrixTranspose(arr1);

        printMatrix(transposeMatrix);
        //transposeMatrixInPlace(arr1);
       // rotateMatrixInPlace(arr1);
      //  int[][] ans = pascal(5);
     //   printMatrix(ans);

       // printMatrix(transposeMatrix);
    }

    private static int[][] pascal(int n) {
        //1
        //11
        //121
        //1231

        int[][] ans = new int[n][];

        for(int i=0; i<n; i++) {
            //ith row has i+1 columns
            ans[i] = new int[i+1];
            // first and last element in every row is 1
            ans[i][0] = ans[i][i] = 1;

            for(int j=1; j<i; j++) {
                ans[i][j] = ans[i-1][j] + ans[i-1][j-1];
            }
        }
        return ans;
    }

    private static void rotateMatrixInPlace(int[][] arr1) {

        transposeMatrixInPlace(arr1);
        for (int i=0; i<arr1.length; i++) {
            reverse(arr1[i]);
        }
    }
    private static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length-1;

        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    private static void transposeMatrixInPlace(int[][] arr1) {

        for(int i=0; i<3; i++) {
            for(int j=i; j<3; j++) { // diagonal se aage koi bhi value galat naho hao
                int temp = arr1[i][j];
                arr1[i][j] = arr1[j][i];
                arr1[j][i] = temp;
            }
        }
    }

    private static int[][] matrixTranspose(int[][] arr1) {

        int[][] ans = new int[arr1.length][arr1[0].length];
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1[i].length; j++) {
                ans[i][j] = arr1[j][i];
            }
        }
        return ans;
    }
    public static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    private static int[][] matrixAddition(int[][] arr1, int[][] arr2) {
        // r1 == r2 || c1 == c2

        if(arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            return new int[0][0];
        }
        int[][] addition = new int[arr1.length][arr2.length];
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1.length; j++) {
                addition[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return addition;

    }

    private static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {
        // c1 == r2 || r1 == c2

        if(arr1[0].length != arr2.length) {
            return new int[0][0];
        }
        int[][] multiplicationArray = new int[arr1.length][arr2[0].length];
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr1.length; j++) {
                // multi[i][j]= ith row of a * jth col of b
                for (int k=0; k< arr1[0].length; k++) {
                    multiplicationArray[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return multiplicationArray;

    }

    private static void printMatrix(int[][] arr) {

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }



}
