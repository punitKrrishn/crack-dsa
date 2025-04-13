package Queue;

import java.util.Stack;

class QueueUsingTwoStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Push element to stack1
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation: Pop element from stack2
    public int dequeue() {
        if (stack2.isEmpty()) {
            // If stack2 is empty, move elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.pop();
    }

    // Peek operation: Look at the front element of the queue
    public int peek() {
        if (stack2.isEmpty()) {
            // If stack2 is empty, move elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    // isEmpty operation: Check if both stacks are empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.peek()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek()); // Output: 2
        System.out.println(queue.isEmpty()); // Output: false
    }
}

