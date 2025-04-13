package Stacks;

import java.util.Stack;

public class MinStack {
    Stack<Integer> s; // Normal stack to hold elements
    Stack<Integer> ss; // Stack to hold the minimum elements
    int size; // Keep track of the size of the stack

    MinStack() {
        s = new Stack<>();
        ss = new Stack<>();
        size = 0;
    }

    // Push operation to insert elements
    void push(int x) {
        s.push(x);
        // If ss is empty or the current element is smaller than or equal to the top of ss, push it onto ss
        if (ss.isEmpty() || x <= ss.peek()) {
            ss.push(x);
        }
        size++;
    }

    // Pop operation to remove the top element
    int pop() {
        if (size == 0) {
            return -1; // Stack is empty
        }
        int ans = s.pop();
        // If the popped element is the same as the top of ss, pop from ss as well
        if (ans == ss.peek()) {
            ss.pop();
        }
        size--;
        return ans;
    }

    // Get the minimum element in the stack
    int getMin() {
        if (size == 0) {
            return -1; // Stack is empty
        }
        return ss.peek(); // The top of ss is the minimum element
    }

    // Get the top element of the stack
    int top() {
        if (size == 0) {
            return -1; // Stack is empty
        }
        return s.peek(); // Return the top element of the normal stack
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // Returns 0.
        System.out.println(minStack.getMin());   // Returns -2.
    }
}
