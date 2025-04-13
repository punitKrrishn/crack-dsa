package Stacks;

import java.util.Stack;

public class MinStackO1 {
    Stack<Integer> s; // Stack to hold elements

    MinStackO1() {
        s = new Stack<>();
    }

    // Push operation to insert elements
    void push(int x) {
        if (s.isEmpty()) {
            s.push(x); // Push the first element
        } else {
            // Push the element and the current minimum
            x = Math.min(x, s.peek()); // The new minimum is the smaller of current element and the previous minimum
            s.push(x);
        }
    }

    // Pop operation to remove the top element
    int pop() {
        if (s.isEmpty()) {
            return -1; // Stack is empty
        }
        return s.pop(); // Just pop the element
    }

    // Get the minimum element in the stack
    int getMin() {
        if (s.isEmpty()) {
            return -1; // Stack is empty
        }
        return s.peek(); // Return the top element which is the current minimum
    }

    // Get the top element of the stack
    int top() {
        if (s.isEmpty()) {
            return -1; // Stack is empty
        }
        return s.peek(); // Return the top element
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
