package recursion;

public class Factorial {
    public static void main(String[] args) {
        int ans = fact(5);
        System.out.println(ans);

    }

    private static int fact(int n) {
        // fact(5) = 5*4*3*2*1
        if(n == 0) {
            return 1;
        }
        int smallAns = fact(n-1);
        int ans = n * smallAns;

        return ans;
    }
}
