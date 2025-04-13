package LinkedList.Questions;

public class LinkedListIntersection {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Static method to get the length of a linked list
    public static int getLength(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Non-static method to find the intersection point of two linked lists
    public Node intersection(Node head1, Node head2) {
        // We call the static method getLength directly
        int length1 = getLength(head1);  // Static method called here
        int length2 = getLength(head2);  // Static method called here

        Node temp1 = head1;
        Node temp2 = head2;

        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                temp1 = temp1.next;
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                temp2 = temp2.next;
            }
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;  // Intersection point found
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;  // No intersection
    }

    public static void main(String[] args) {
        Node a1 = new Node(10);
        Node a2 = new Node(20);
        Node a3 = new Node(30);
        Node a4 = new Node(40);

        Node b1 = new Node(15);
        Node b2 = new Node(25);

        // Intersection starts at node with value 30
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        b1.next = b2;
        b2.next = a3; // Intersection point here (Node with value 30)

        LinkedListIntersection list = new LinkedListIntersection();
        Node intersectionNode = list.intersection(a1, b1);
        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.data);
        } else {
            System.out.println("No intersection.");
        }
    }
}
