package Arrays;

import java.util.Arrays;

public class HashSet {
    int[] arr;
    private HashSet() {
        arr = new int[10005];
        Arrays.fill(arr,-1);
    }
    void add(int val) {
        arr[val] = val;
    }
    int get(int val) {
        return arr[val];
    }
    void remove(int val) {
         arr[val] = -1;
    }
    public static void main(String[] args) {

    }
}
