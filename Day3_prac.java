package Practise;

public class Day3_prac {

    public static void printArr(int[] arr) {
        for(int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    // move 0's to the right end
    public static void moveRight(int[] arr) {
        int i=0;

        for(int j=0; j<arr.length; j++) {
            if(arr[j] != 0) {
                arr[i] = arr[j];
                i++;
            }
        }

        for(; i<arr.length; i++) {
            arr[i] = 0;
        }

        printArr(arr);
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,1};
        moveRight(arr);
    }
}
