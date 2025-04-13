package LinkedList;

public class SinglyLinkedList {
    private static Node head = null;
    private static Node tail = null;

    // Define the Node class that represents each element in the LinkedList
    public static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node temp = new Node(data);

        if (head == null) { // Base case for empty list
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public void printListRev(Node head) {
        if (head == null) { // Base case for empty or end of recursion
            return;
        }
        printListRev(head.next);
        System.out.print(head.data + " ");
    }

    public void insertAtLast(int data) {
        Node temp = new Node(data);

        if (head == null || tail == null) { // Base case for empty list
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public void insertEnd(int data) {
        Node curr = head;
        Node temp = new Node(data);

        if (curr == null) { // Base case for empty list
            head = temp;
            tail = temp;
            return;
        }

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }

    public void insertBeginning(int data) {
        Node temp = new Node(data);
        if (head == null) { // Base case for empty list
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public void insertAt(int index, int data) {
        if (index < 0 || index > size()) { // Base case for invalid index
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) { // Insert at the beginning
            insertBeginning(data);
            return;
        }

        if (index == size()) { // Insert at the end
            insertAtLast(data);
            return;
        }

        Node temp = new Node(data);
        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;
    }

    public int getElement(int index) {
        Node curr = head;

        if (index < 0 || index >= size()) { // Base case for invalid index
            return 0;
        }

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public static int size() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void printList() {
        if (head == null) { // Base case for empty list
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.insertAt(9, 0);
        System.out.println(sll.getElement(4));
        printList();
        sll.printListRev(head);
    }
}
