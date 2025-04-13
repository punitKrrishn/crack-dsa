package LinkedList.Questions;

public class DeleteNode {
    // Define the Node class
    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to delete a node
    public void deleteNode(Node node) {
        node.val = node.next.val;  // Copy the value of the next node to the current node
        node.next = node.next.next;  // Skip the next node
    }

    // Helper function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteNode list = new DeleteNode();

        // Creating a sample linked list 4 -> 5 -> 1 -> 9
        Node head = list.new Node(4);
        Node second = list.new Node(5);
        Node third = list.new Node(1);
        Node fourth = list.new Node(9);
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Print the original list
        System.out.print("Original List: ");
        list.printList(head);

        // Delete the node with value 1 (third node)
        list.deleteNode(third);

        // Print the updated list
        System.out.print("Updated List: ");
        list.printList(head);
    }
}
