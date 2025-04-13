package TCSNQT_Coding_Questions.Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        int max = 1;
        int pre = 1;
        int suf = 1;
        for(int i=0; i<arr.length; i++) {
            pre = pre * arr[i];
            suf = suf * arr[arr.length-i-1];
            if(pre == 0) {
                pre = 1;
            }
            if(suf == 0) {
                suf = 1;
            }
            max = Math.max(Math.max(pre,suf),max);

        }

        System.out.println("product ans "+max);



    }
}
