package Practise;

import java.util.*;

public class Day13 {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyList {

        Node head, tail;

        private boolean isEmpty() {
            return head == null;
        }

        private int size() {
            if(this.isEmpty()) {
                return 0;
            }

            int count = 0;
            Node temp = head;
            while(temp!=null) {
                count++;
                temp = temp.next;
            }

            return count;
        }

        private void add(int data) {
            Node newNode = new Node(data);

            if(this.isEmpty()) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        private void add_first(int data) {
            Node newNode = new Node(data);
            if(this.isEmpty()) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        private void add_k(int data, int k) {
            if(k == 0) {
                return;
            }

            if(k == 1 || this.isEmpty()) {
                add_first(data);
            } else if(k == this.size()) {
                add(data);
            } else {
                Node newNode = new Node(data);
                Node temp = head, prev = head;
                while(k-1 > 0) {
                    prev = temp;
                    temp = temp.next;
                    k--;
                }

                prev.next = newNode;
                newNode.next = temp;
            }
        }

        private Node remove() {
            if(this.isEmpty()) {
                System.out.println("Empty list");
                return null;
            }
            Node temp = head, prev = head;
            while(temp.next != null) {
                prev = temp;
                temp = temp.next;
            }

            prev.next = null;
            tail = prev;

            return temp;
        }

        private Node remove_k(int k) {
            if(this.isEmpty() || k == 0) {
                return null;
            }

            if(k == 1) {
                return remove_first();
            } else if(k == this.size()) {
                return remove();
            } else {
                Node temp = head, prev = head;
                while(k-1 > 0) {
                    prev = temp;
                    temp = temp.next;
                    k--;
                }

                prev.next = temp.next;
                temp.next = null;
                return temp;
            }
        }

        private Node removeLast_k(Node head, int k) {
            if(k == this.size()) {
                return this.remove_first();
            } else if(k == 1) {
                return remove();
            } else {
                int pos = this.size()-k+1;
                return remove_k(pos);
            }
        }

        private Node remove_first() {
            if(this.isEmpty()) {
                System.out.println("Empty list");
                return null;
            }

            Node temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }

        private void printList() {
            Node temp = head;
            while(temp!=null) {
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        private Node reverse() {
            tail = head;
            Node curr = head, prev=null, next;
            while(curr!=null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
            return head;
        }

        private boolean isCycle(Node head) {
            Node slow = head, fast = head;
            while(fast!=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {return true;}
            }
            return false;
        }

        private int lengthOfCycle(Node head) {
            if(!isCycle(head)) {return 0;}
            Node slow = head, fast = head;
            while(fast!=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {break;}
            }

            int cnt=1;
            slow = head;
            while(fast != slow && fast!=null) {
                fast = fast.next;
                cnt++;
            }
            return cnt;
        }

        private void removeCycle(Node head) {
            Node slow = head, fast = head;
            while(fast!=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {break;}
            }

            slow = head;
            Node prev = fast;
            while(fast!=slow) {
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
        }
    }

    static class DNode {
        int data;
        DNode next;
        DNode prev;

        public DNode(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    static class DoublyList {
        DNode head, tail;

        private boolean isEmpty() {
            return head == null;
        }

        private void add(int data) {
            DNode newNode = new DNode(data);

            if(this.isEmpty()) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        private DNode remove() {
            if(this.isEmpty()) {
                return null;
            }

            DNode temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }

            tail = temp.prev;
            temp.prev.next = null;
            temp.prev = null;

            return temp;
        }

        private int size() {
            if(this.isEmpty()) {
                return 0;
            }

            DNode temp = head;
            int cnt = 0;

            while(temp!= null) {
                temp = temp.next;
                cnt++;
            }

            return cnt;
        }

        private void printList() {
            DNode temp = head;
            while(temp!=null) {
                System.out.print(temp.data+ " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        private void add_k(int data, int pos) {
            DNode newNode = new DNode(data);
            DNode temp = this.head;
            while(pos > 0) {
                temp = temp.next;
                pos--;
            }

            DNode prev = temp.prev;
            prev.next = newNode; newNode.prev = prev;
            newNode.next = temp; temp.prev = newNode;
        }

        private DNode remove_k(int pos) {
            DNode temp = this.head;
            while(pos > 0) {
                temp = temp.next;
                pos--;
            }
            DNode prev = temp.prev;
            prev.next = temp.next; temp.next.prev = prev;

            return temp;
        }
    }


    static class CirclularList {
        Node head;

        private boolean isEmpty() {
            return head == null;
        }

        private void add(int data) {
            Node newNode = new Node(data);
            if(this.isEmpty()) {
                head = newNode; newNode.next = head;
                return;
            }

            Node temp = head;
            while(temp.next!=head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        private Node remove() {
            if(this.isEmpty()) {
                return null;
            }
            Node temp = head, prev = head;
            while(temp.next != head) {
                prev = temp;
                temp = temp.next;
            }

            prev.next = head;
            temp.next = null;
            return temp;
        }

        private int size() {
            Node temp = head; int cnt = 0;
            while(temp.next!= head) {
                temp = temp.next;
                cnt++;
            }
            return cnt+1;
        }

        private void printList() {
            if(this.isEmpty()) {return;}
            Node temp = head.next;
            System.out.print(head.data+" ");
            while(temp != head) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println("head");
        }
    }

    public static Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverse(Node head) {
        Node curr = head, prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public static Node addNode(Node head) {
        // Write your code here.
        head = reverse(head);
        Node temp = head, prev = null;

        while(temp!=null) {
            prev = temp;
            temp.data = (temp.data+1)%10;
            if(temp.data != 0) {break;}
            temp = temp.next;
        }

        if(temp == null) {
            prev.next = new Node(1);
        }
        head = reverse(head);
        return head;
    }

    public static Node add2Nums(Node head1, Node head2) {
        Node resHead = null, res = null;
        int flag = 0;

        while(head1!=null && head2!=null) {
            int sum = head1.data + head2.data + flag;
            Node newNode = new Node(sum%10);
            if(resHead == null) {
                resHead = res = newNode;
            } else {
                res.next = newNode;
                res = newNode;
            }
            flag = sum / 10;
            head1 = head1.next; head2 = head2.next;
        }

        while(head1 != null) {
            int sum = head1.data + flag;
            Node newNode = new Node(sum%10);
            flag = sum/10;

            res.next = newNode;
            res = newNode;

            head1 = head1.next;
        }
        while(head2 != null) {
            int sum = head2.data + flag;
            Node newNode = new Node(sum%10);
            flag = sum/10;

            res.next = newNode;
            res = newNode;
            head2 = head2.next;
        }

        if(flag == 1) {
            res.next = new Node(1);
        }

        resHead = reverse(resHead);
        return resHead;
    }

    public static Node deleteMiddle(Node head) {
        if(head.next == null) {return null;}
        // Write your code here.
        Node prev = null;
        Node slow = head, fast = head;

        while(fast!=null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
    }

    public static Node findMid(Node head) {
        Node slow = head, fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node left, Node right) {
        Node merged = new Node(-1);
        Node ptr = merged;
        while(left!=null && right!=null) {
            if(left.data <= right.data) {
                ptr.next = left;
                left = left.next;
            } else {
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }

        while(left!=null) {
            ptr.next = left;
            left = left.next; ptr = ptr.next;
        }
        while(right!=null) {
            ptr.next = right;
            right = right.next; ptr = ptr.next;
        }

        return merged.next;
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node rhead = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(rhead);

        return merge(left, right);
    }



    public static void main(String[] args) {
        SinglyList list = new SinglyList();
        int[] arr = {12,8,2,9,6,5};
        for(int item : arr) {
            list.add(item);
        }
        list.printList();
        list.head = mergeSort(list.head);
        list.printList();
    }
}
