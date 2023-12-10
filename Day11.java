package Practise;

public class Day11 {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static Node findMid(Node head) {
        Node slow=head, fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(1);

        System.out.println(findMid(head).data);
        printList(head);
    }
}
