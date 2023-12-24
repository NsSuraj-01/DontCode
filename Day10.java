package Practise;

import java.util.*;
public class Day10 {

    public static int merge(int[] arr, int si, int mid, int ei) {
        int i = si, j = mid;
        int ni = 0;
        int[] temp = new int[ei-si+1]; int k=0;

        while(i<mid && j<=ei) {
            if(arr[i] > arr[j]) {
                ni = ni + (mid-i);
                temp[k] = arr[j];
                j++;
            } else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }

        while(i<mid) {
            temp[k++] = arr[i++];
        }
        while(j<=ei) {
            temp[k++] = arr[j++];
        }

        k=0;
        for(int idx=si; idx<=ei; idx++) {
            arr[idx] = temp[k++];
        }

        return ni;
    }

    public static int mergeSort(int[] arr, int si, int ei) {
        int ni = 0;

        if(si == ei) {
            return 0;
        }

        if(ei>si){
            int mid = si + (ei - si) / 2;
            ni = mergeSort(arr, si, mid);
            ni += mergeSort(arr, mid + 1, ei);
            ni += merge(arr, si, mid+1, ei);
        }
        return ni;
    }

    public static int countInv(int[] arr, int N) {
        return mergeSort(arr, 0, N-1);
    }


    public static void printMatrix(int[][] matr) {
        for(int[] row : matr) {
            for(int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    public static void rotateArr(int[] arr, int si, int ei) {
        while(si<ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;

            si++; ei--;
        }
    }

    public static void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(i > j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    /*
        input           output
        1	2	3	    3	6	9
        4	5	6	    2	5	8
        7	8	9	    1	4	7
    */
    public static void rotate90_1(int[][] matrix) {

        // 1.rotate each row of the matrix
        for(int[] row : matrix) {
            rotateArr(row, 0, row.length-1);
        }

        // 2.transpose of the matrix
        transpose(matrix);

        printMatrix(matrix);
    }

    /*
        input               output
        1	2	3	        7	4	1
        4	5	6	        8	5	2
        7	8	9	        9	6	3
    */
    public static void rotate90_2(int[][] arr) {
        // 1. transpose
        transpose(arr);

        // 2. rotate each row
        for(int[] row : arr) {
            rotateArr(row,0, row.length-1);
        }

        printMatrix(arr);
    }

    public static void perm(ArrayList<Integer> arr, ArrayList<Integer> res) {
        if(arr.isEmpty()) {
            System.out.println(res);
            return;
        }

        for(int i=0; i<arr.size(); i++) {
            int num = arr.get(i);
            arr.remove(i);
            res.add(num);
            perm(arr, res);
            arr.add(num);
        }
    }

    public static void printArr(int[] arr) {
        for(int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void nextPerm(int[] perm) {

        int N = perm.length;
        // find if it is the last perm
        int i;
        for(i=0; i<N-1; i++) {
            if(perm[i] < perm[i+1]) {break;}
        }
        if(i == N) {
            rotateArr(perm, 0, N-1);
            return;
        }

        // otherwise find the break point
        int prev=0;
        for(i=0; i<N; i++) {
            if(perm[i] > perm[i+1]) {
                break;
            }
            prev = i;
        }
        // find the next closest idx
        int idx = i;
        for(; i<N; i++) {
            int diff = perm[idx]-perm[prev];
            if(perm[i] - perm[prev] < diff) {
                idx = i;
            }
        }

        // swap the idx elem with prev elem
        int temp = perm[prev];
        perm[prev] = perm[idx];
        perm[idx] = temp;

        // rotate the arr from i -> N-1
        rotateArr(perm, prev+1, idx);

        printArr(perm);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        nextPerm(arr);
    }
}


