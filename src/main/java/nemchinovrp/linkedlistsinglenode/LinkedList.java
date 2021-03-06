package nemchinovrp.linkedlistsinglenode;

class LinkedList {

    static Node head;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
//        head = list.reverse(head);
        head = list.recursiveReverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            //     System.out.println(node.data + " - - ");
            next = current.next;
            current.next = prev; // хз зачем это
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public Node recursiveReverse(Node current) {
        if (current == null) {
            return null;
        } else if (current.next == null) {
            return current;
        } else {
            Node nextNode = current.next;
            current.next = null;
            Node rest = recursiveReverse(nextNode);
            nextNode.next = current;
            return rest;
        }
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}