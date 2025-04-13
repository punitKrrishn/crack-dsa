package recursion;

public class Power {
    public static void main(String[] args) {
        //int ans = powerIte(5,4);
        int ans = power(5,4);
        System.out.println(ans);
    }

    static int powerIte(int x,int y) {
        int ans = 1;
        for(int i=1; i<=y; i++) {
            ans = ans * x;
        }
        return ans;
    }

    static int power(int p, int q) {

        // 5^4 = 5^0 * 5^1 * 5^2 * 5^3 : f(n) =  f(p,q-1) * p  // 5^0 = 1 so, we multiply 5
        if(q == 0) {
            return 1;
        }
        int smallAns = power(p,q-1);
        return smallAns * p;
    }

}
