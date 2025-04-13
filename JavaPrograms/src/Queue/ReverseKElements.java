package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        int k = 2;
        Queue<Integer> ans = reverseKElements(q,k);
        System.out.println(ans);
    }

    public static Queue<Integer> reverseKElements(Queue<Integer> q, int k) {

        Stack<Integer> st = new Stack<>();
        Queue<Integer> q2 = new LinkedList<>();

        while (k != 0) {
            st.push(q.poll());
            k--;
        }
        while (!st.isEmpty()) {
            q2.add(st.pop());
        }
        for(int i=k; i<=q.size(); i++) {
            q2.add(q.poll());
        }
        return q2;


    }
}
