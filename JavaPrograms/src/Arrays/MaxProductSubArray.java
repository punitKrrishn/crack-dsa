package Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2,3,-3,4,5};
        int ans = maxProduct2(arr);
        System.out.println(ans);
    }

    public static int maxProduct(int[] arr) {
        int maxProd = 1;

        // case 1 : all +ve max
        // case 2 : even -ve = +ve max
        // case 3 : odd -ve = -ve
        // case 4 : contain o = o

        for(int i=0; i<arr.length; i++) {

            for(int j=i; j<arr.length; j++) {
                int currProd = 1;
                for(int k=i; k<=j; k++) {
                    currProd = currProd * arr[k];
                    maxProd = Math.max(currProd,maxProd);
                }
            }
        }

        return maxProd;
    }

    public static int maxProduct2(int[] arr) {
        int maxProd = 1;

        // case 1 : all +ve max
        // case 2 : even -ve = +ve max
        // case 3 : odd -ve = -ve
        // case 4 : contain o = o

        for(int i=0; i<arr.length; i++) {
            int currProd = 1;
            for(int j=i; j<arr.length; j++) {
                currProd = currProd * arr[j];
                maxProd = Math.max(currProd,maxProd);
            }
        }

        return maxProd;
    }


}
