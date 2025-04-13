package Arrays;

public class FrequencyArray {
    public static void main(String[] args) {
        int[] arr = {2,4,2,5};
        int[] freq = new int[10005];

        for(int i=0; i<arr.length; i++) {
            freq[arr[i]] = freq[arr[i]] + 1;
        }
        int val = 2;

        if(freq[val] == val) {
            System.out.println("Yes");
        }else  {
            System.out.println("no");
        }
    }
}
