package Practise;


import java.util.*;
public class Day_7 {

    public static void printArr(int[] arr) {
        for(int item : arr) {
            System.out.print(item+" ");
        }
        System.out.println();
    }

    // constant space, time -> O((n+m)*log(n+m))
    public static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i=n-1;
        int j=0;

        while(i>=0 && j<m) {
            if(arr1[i] > arr2[j]) {
                // keep it in right place
                int temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
            } else {
                // they are in the right place
                break;
            }
            i--; j++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {0,2,6,8,9};

        merge(arr1, arr2, arr1.length, arr2.length);
        printArr(arr1);
        printArr(arr2);
    }
}
