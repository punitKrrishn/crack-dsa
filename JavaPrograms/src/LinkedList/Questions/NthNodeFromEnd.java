package LinkedList.Questions;

import LinkedList.SinglyLinkedList;

public class NthNodeFromEnd {


    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public static Node nthNode(int index,Node a) {
        Node curr = a;
        if(curr == null) {
            return null;
        }
        for(int i = 0; i<index-1; i++) {
            curr = curr.next;
        }
        return curr;
    }
    public static void printListRev(Node a) {
        if(a == null) {
            return;
        }
        printListRev(a.next);
        System.out.print(a.data+" ");
    }

    public  static Node nthFromEnd(Node a, int n) {
        int size = getSize(a);
        Node temp = a;
        int m = size - n + 1; //like  6-3 + 1 if n=3 give the index from end;
        for(int i=0; i<m-1; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public static int getSize(Node a) {
        int size = 0;
        Node curr = a;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    public static void printList(Node a) {
        Node curr = a;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public Node nthNodeTwoPointer(Node a, int n) {
        Node slow = a;
        Node fast = a;

        // Move the first pointer 'n' steps ahead
        for (int i = 0; i < n; i++) { // follow the n-1 steps becoz at first index we have send node
            if (fast == null) {
                System.out.println("The list has less than " + n + " nodes.");
                return null; // If the list has fewer than n nodes
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static Node deleteNthFromEnd(Node a, int n) {
        // Handle the case where 'n' is less than or equal to 0, or the list is empty
        if (n <= 0 || a == null) {
            System.out.println("Invalid index.");
            return a;
        }

        Node slow = a;
        Node fast = a;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {  // If n is greater than the length of the list, return the list as is
                System.out.println("n is greater than the length of the list.");
                return a;  // Nothing to delete, return the original list
            }
            fast = fast.next;
        }

        // If fast is null after the loop, the node to delete is the head
        if (fast == null) {
            return a.next;  // Remove the head node
        }

        // Move both fast and slow pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Now slow is at the (n+1)th last node, so delete the nth node from the end
        slow.next = slow.next.next;

        return a;  // Return the updated list
    }


    public static void main(String[] args) {

            Node a = new Node(10);
            Node b = new Node(20);
            Node c = new Node(30);
            Node d = new Node(40);
            Node e = new Node(50);
            a.next = b;
            b.next = c;
            c.next = d;
            d.next = e;
            printList(a);
           // printListRev(a);
           // System.out.println();
           // Node ans = nthNode(2,a);
           // Node ans = nthFromEnd(a,2);
           Node ansHead = deleteNthFromEnd(a,7);
            printList(ansHead);
           // System.out.println(ans.data);


    }
}
