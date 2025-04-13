package Stacks;

public class LinkedListStack {

    private static ListNode head = null;
    private static int size = 0;

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private void push(int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = head;
        head = newNode;
        size++;
    }

    private int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int top = head.val;
        return top;
    }

    private int pop() {
     if (isEmpty()) {
        return -1;
     }
     int popped = head.val;
     head = head.next;
     size--;
     return popped;
    }
    private void recRev(ListNode head) {
        if(head == null) {
            return;
        }
        recRev(head.next);
        System.out.print(head.val+" ");

    }
    private void display() {
        recRev(head);
        System.out.println();
    }

    private void displayRev() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    private int size(){
        return size;
    }

    private boolean isEmpty() {
         return head == null || size == 0;
    }

    public static void main(String[] args) {
        LinkedListStack all = new LinkedListStack();
        all.push(1);
        all.push(2);
        all.push(3);
        all.push(4);

        all.display(); // 1 2 3, 4
        System.out.println("Popped Element : "+all.pop()); // 4
        all.display(); // 1 2 3, 4
        System.out.println("Peak Element : "+all.peek()); // 3
        System.out.println("Stack size : "+all.size()); // 3
        System.out.println("is Empty : "+all.isEmpty()); // false


    }
}
