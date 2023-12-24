package Practise;

import java.util.*;
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

    // O(N)
    // num of sub-arrays with sum = k
    public static void subset_opt(int[] arr, int X) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        map.put(0,1);
        int xor = 0;

        for(int i : arr) {
            xor = xor^i;
            // front xor
            int xr = xor ^ X;
            if(map.containsKey(xr)) {
                cnt += map.get(xr);
            }
            map.put(xor,1);
        }

        System.out.println(cnt);

    }

    // bruteForce -> O(N^3)
    public static void subset_3(int[] arr, int X) {
        int N = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> currRes ;

        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                int val=0;
                currRes = new ArrayList<>();
                for(int k=i; k<=j; k++) {
                    val = val^arr[k];
                    currRes.add(arr[k]);
                }
                if(val == X) {
                    res.add(currRes);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
//        head = new Node(2);
//        head.next = new Node(4);
//        head.next.next = new Node(6);
//        head.next.next.next = new Node(7);
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(1);
//
//        System.out.println(findMid(head).data);
//        printList(head);

        int[] arr = {6,9,4,2};
        subset_opt(arr, 6);
    }
}
