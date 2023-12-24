package Practise;

import java.util.*;

public class Day13 {

    static class Node {
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



    public static void main(String[] args) {
        CirclularList list = new CirclularList();
        for (int i = 0; i < 10; i = i + 2) {
            list.add(i);
        }

        System.out.println("removed: " + list.remove().data);
        System.out.println("size: " + list.size());
        list.printList();
    }
}
