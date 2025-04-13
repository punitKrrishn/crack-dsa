package recursion;

import java.util.Scanner;

public class PrintMultiples {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        printMul(n, k);
    }

    public static void printMul(int x, int y) {
        // 5 = 5*1,5*2,5*3,5*4 : f(x,y) = f(x,y-1) * x
        //Base Case : if y <= 0 return 1;

        if(y == 0) {
            return;
        }
        printMul(x,y-1);
        System.out.print(x * y+ " ");
    }
}
