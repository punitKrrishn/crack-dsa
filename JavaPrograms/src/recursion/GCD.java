package recursion;

public class GCD {
    public static void main(String[] args) {
        int ans = GCDRec(24,15);
        System.out.println(ans);
    }
    public static int GCD(int x, int y) {
        // f(x,y) = f(y, x%y) so y divide our x
        while(x % y != 0) {
            int rem = x % y;
            x = y;
            y = rem;
        }
        return y;
    }

    public static int GCDRec(int x, int y) {

        if(x % y == 0) {
            return y;
        }
        return GCDRec(y,x%y);
    }
}
