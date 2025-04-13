package recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        int ans = fibo(6);
        printFiboSeries(10);
       // System.out.println(ans);
    }
    public static int fibo(int n) {
        // fibo(6) = 0,1,1,2,3,5,8,12
        // Base Case : if n ==1 || n == 0 return n
        if(n==0 || n==1) {
            return n;
        }
        // f(n) = f(n-1) + f(n-1)
        return fibo(n-1) + fibo(n-2);
    }
    public static void printFiboSeries(int n) {

        for(int i=0; i<n; i++) {
            System.out.print(fibo(i)+" ");
        }
    }
}
