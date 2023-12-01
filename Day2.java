package Practise;

import java.util.*;
public class Day2 {
    // q1 -> left rotate the given array 'd' times
    // q2 -> remove duplicates from the given array and return the number of distinct elem

    public static void rev(int[] arr, int si, int ei) {
        while(si < ei) {
            // swap
            int temp = arr[ei];
            arr[ei] = arr[si];
            arr[si] = temp;

            si++; ei--;
        }
    }

    // time -> O(N), space -> O(1)
    public static void q1_opt(int[] arr, int n, int d) {

        if(d>n) {
            return;
        }

        rev(arr, 0, n-1);
        rev(arr, 0, n-1-d);
        rev(arr, n-d, n-1);
    }


    // time -> O(N), space-> O(N)
    public static void q1_app1(int[] arr, int n, int d) {
        if(d > n) {
             return;
         }

         Queue<Integer> q = new LinkedList<>();

         for(int i : arr) {
             q.add(i);
         }

         while(d --> 0) {
             int curr = q.remove();
             q.add(curr);
         }

         int  i = 0;
         while(!q.isEmpty()) {
             arr[i++] = q.remove();
         }
    }

    // time -> O(N), space -> O(1)
    public static void q2_opt(int[] arr) {
        int n = arr.length;

        int p = 0;
        for(int q=1; q<n; q++) {
            if(arr[p] != arr[q]) {
                p++;
                arr[p] = arr[q];
            }
        }

        for(int i=0; i<=p; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // time -> O(N*logN), space -> O(N)
    public static void q2_app1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : arr) {
            set.add(i);
        }

        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 4;

        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
    }
}


