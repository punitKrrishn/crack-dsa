package recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 5693;
        int ans = digitsSum(n);
        System.out.println(ans);
    }

    public static int digitsSum(int n) {
        //  5693 = 5+6+9+3 : f(n) = f(n/10) + f(n%10);
        //Base Case : if n==0 return n
        if(n >= 0 &&  n <= 9) {
            return n;
        }
        int smallAns = digitsSum(n/10);
        return smallAns + digitsSum(n%10);
    }
}
