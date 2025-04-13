package recursion;

public class AltSignSum {
    public static void main(String[] args) {
       // int[] arr = {1,-2,3,-4,5,-6};
        int n = 10;
        int ans = altSum(n);
        System.out.println(ans);
    }
    public static int altSum(int n) {
        // f(n) =  f(n-1) + n sum of n natural numbers
        if(n == 0) {
            return 0;
        }
        if(n%2== 0) {
           return altSum(n-1) - n;
        }else {
            return altSum(n-1) + n;
        }

    }
}
