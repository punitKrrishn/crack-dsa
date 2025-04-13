package Stacks;

public class ArrayStack {
    private int[] arr = new int[4];
    private static int idx = 0;

    // Push method to add an element to the stack
    void push(int x) {
        if(isFull()) {
            System.out.println("Stack is full!!");
            return;
        }
        arr[idx] = x;
        idx++;

    }

    // Peek method to return the top element of the stack
    int peek() {
        if (idx == 0) {
            System.out.println("Stack is empty!!");
            return -1;
        }
        return arr[idx - 1];
    }

    // Pop method to remove and return the top element of the stack
    int pop() {
        if (idx == 0) {
            System.out.println("Stack is empty !!");
            return -1;
        }
        int x = arr[idx - 1];
        arr[idx - 1] = 0;
        idx--;
        return x;
    }

    // Size method to return the current size of the stack
    int size() {
        return idx;
    }

    // Method to display the elements in the stack
    void display() {
        if (idx == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < idx; i++) {
            System.out.print(arr[i]);
            if (i != idx - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Capacity method to return the current capacity of the array
    int capacity() {
        return arr.length;
    }

    // Check if the stack is full
    boolean isFull() {
        return size() == capacity();
    }

    // Resize the array when the stack is full (double the size)
    private void resize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.println("Stack resized. New capacity: " + arr.length);
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayStack st = new ArrayStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.display(); // [1, 2, 3, 4]

        st.pop();
        st.display(); // [1, 2, 3]

        System.out.println("peek is " + st.peek()); // 3
        System.out.println("size is " + st.size()); // 3
        System.out.println("capacity is " + st.capacity()); // 6 (doubled size after resizing)
       // System.out.println("isFull " + st.isFull()); // false
    }
}
