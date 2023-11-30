package Practise;

import java.util.*;

public class Sorting_techniques {

    public static void printArr(int[] arr) {
        for(int elem : arr) {
            System.out.print(elem+" ");
        }
        System.out.println();
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int i=si, j=mid+1, k=0;
        int[] b = new int[ei-si+1];

        while((i<=mid) && (j<=ei)) {
            if(arr[i] <= arr[j]) {
                b[k++] = arr[i++];
            } else {
                b[k++] = arr[j++];
            }
        }

        // copy remaining elem
        while( i<=mid ) {
            b[k++] = arr[i++];
        }

        while(j<=ei) {
            b[k++] = arr[j++];
        }

        i = si; k=0;
        for(; i<=ei && k<b.length; i++, k++) {
            arr[i] = b[k];
        }
    }

    // time -> n*logN, space -> O(N)
    public static void mergeSort(int[] arr, int si, int ei) {
        if(si >= ei) {
            return;
        }

        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static int partition(int[] arr, int si, int ei) {
//        if(si == ei) {
//            return si;
//        }

        int i = si, j = si+1;
        int x = arr[i], pivot = si;

        while(j<=ei) {
            if(arr[j] <= x) {
                i++;
                // swap elems at i, j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        // swap ith elem and pivot
        int temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;
        pivot = i;

        return pivot;
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            int idx = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

    // O(n^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {

            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {

            int j = i-1;
            while(j>=0) {
                if(arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i = j;
                }
                j--;
            }
        }
    }

    public static void countSort(int[] arr) {
        int n = arr.length;

        int max = 0;
        for(int i : arr) {
            max = Math.max(max, i);
        }

        int[] freq = new int[max+1];

        for(int i : arr) {
            freq[i]++;
        }

        int i=0, k=0;
        for(; k< freq.length; k++) {
            if(freq[k] > 0){
                while(freq[k] > 0) {
                    arr[i++] = k;
                    freq[k]--;
                }
            }
        }
    }

    // time -> O(N*logN), space -> constant
    public static void quickSort(int[] arr, int si, int ei) {
        if(si >= ei) {
            return;
        }

        int m = partition(arr, si, ei);
        quickSort(arr, si, m-1);
        quickSort(arr, m+1, ei);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,9,6,15,3};
        int n = arr.length;
        countSort(arr);
        printArr(arr);

    }
}
