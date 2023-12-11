package Practise;

import java.util.*;

public class Day9 {

    public static void printArr(int[] arr) {
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void rotateArr(int[] arr, int si, int ei) {
        while(si < ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;

            si++; ei--;
        }
    }

    // time -> O(N)
    public static List<Integer> nextPerm(int[] arr) {
        int N = arr.length;
        List<Integer> res = new ArrayList<>();
        int i;
        // 1. find the break point
        for(i=N-2; i>=0; i--) {
            if(arr[i] < arr[i+1]) {
                break;
            }
        }

        if(i == -1){
            rotateArr(arr,0, N-1);
            for(int item : arr) {
                res.add(item);
            }
            return res;
        }
        // 2. find the idx of the closest elem
        int j=i+1;
        int idx = j;
        while(j<N && arr[i]<arr[j]) {
            if(arr[idx] >= arr[j]) {
                idx = j;
            }
            j++;
        }
        System.out.println(idx);

        // 3. swap
        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;

        // 4. rotate the right part of breakpoint to get the nextPer
        rotateArr(arr, i+1, N-1);
        for(int item : arr) {
            res.add(item);
        }
        return res;

    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,6,5,4};
//        int[] arr = {3,2,1};
        int[] arr = {2,3,1,3,3};
        System.out.println(nextPerm(arr));


    }
}
