package recursion;

public class SeriesSum {
    public static void main(String[] args) {
        int ans = seriesSum(4); //1,2,3,4 = 10
        System.out.println(ans);
    }
    public static int seriesSum(int n) {
        // 4 = 1+2+3+4
        //f(n) = f(n-1) + n;
        if(n == 0) {
            return 0;
        }
        int smallAns = seriesSum(n-1);

        //self work
        int ans = smallAns + n;
        return ans;
    }
}
