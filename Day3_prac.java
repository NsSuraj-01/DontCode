package Practise;

public class Day3_prac {

    public static void printArr(int[] arr) {
        for(int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    // time -> O(N), space -> O(1)
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

    // time -> O(N), space -> O(1)
    public static int maximize1s(int[] arr, int k) {
        int n = arr.length;
        int i=0; int maxVal = 0;
        int flips = 0;

        for(int j=0; j<n; j++) {
            if(arr[j] == 0) {
                flips++;
            }

            // if num of flips are greater than k
            while(flips < k) {
                if(arr[i] == 0) {
                    flips--; // flipping back to 0s
                }
                i++;
            }

            int len = j-i+1; // len of 1s
            maxVal = Math.max(maxVal, len);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,1};
        moveRight(arr);
    }
}
