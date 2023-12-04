package Practise;

import java.util.*;
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


    // 1. all possible combinations of sum k i.e, (A[i] + B[j] = k)
    // O(max(M, N)) -> M-sizeof(A), N-sizeof(B)
    public static void p1(int[] A, int[] B, int X) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<B.length; i++) {
            map.put(X-B[i], i);
        }

        for (int val : A) {
            if (map.containsKey(val)) {
                System.out.println(val + " " + B[map.get(val)]);
            }
        }
    }

    // 2. len of longest subArr of sum = k, given that arr contains pos,0,neg nums
    // time -> O(N), space -> O(N)
    public static int p2(int[] A, int N, int K) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum=0;

        for(int i=0; i<N; i++) {
            // calc sum
            sum += A[i];

            // if sum = k, that is the longest possible subArr till that idx
            if(sum == K) {
                maxLen = Math.max(maxLen, i+1);
            }

            // if remSum is present in map, update len
            int remSum = sum-K ;
            if(map.containsKey(remSum)) {
                maxLen = Math.max(maxLen, i-map.get(remSum));
            }

            // otherwise smallest subArr will get for arr -> (2,0,0,3),3
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
//        int[] arr = {1,1,2,3,3,4,4,8,8};
//        int N = arr.length;
//        System.out.println(p3_opt(arr, N));

//        p1(new int[]{-1,-2,4,-6,5,7}, new int[]{6,3,4,0}, 8);

        int[] arr = {1,4,3,3,5,5};
        int[] arr1 = {-1,2,3};
        System.out.println(p2(arr, arr.length, 16));

    }

}
