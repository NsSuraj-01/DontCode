package Practise;

public class Day_4 {

//    3. single element in the sorted array

    // time -> O(N)
    public static int p3(int[] arr, int N) {
        int curr = -1;

        for(int i=0; i<N; i++) {
            if(curr == -1) {
                curr = arr[i];
            } else if (curr == arr[i]) {
                curr = -1;
            }
        }

        return curr;
    }

    // time -> O(logN)
    public static int p3_opt(int[] A, int N) {
        int si = 1, ei = N-2;


        while(si < ei){
            int mid = si + (ei - si) / 2;

            if( (mid & 1) != 0) {
                mid--;
            }

            // I'm on right side
            if(A[mid] != A[mid+1]) {
                ei = mid;
            } else {
                si = mid+2;
            }
        }

        return A[si];

    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        int N = arr.length;
        System.out.println(p3_opt(arr, N));
    }

}
