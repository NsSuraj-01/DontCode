package Practise;

import java.util.*;
public class Day_6 {

    private static void sort(int[] arr, int N) {
        // selection sort

        for(int i=0; i<N; i++) {
            int min = i;
            for(int j=i+1; j<N; j++) {
                if(arr[j] < arr[i]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static long maxSubarraySum(int arr[], int n){

        // Your code here
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        int j=0;

        // if a -ve num exists.?
        for(; j<n; j++) {
            if(arr[j] > 0) {
                break;
            }
        }

        if(j == n) {
            for(int i : arr) {
                maxSum = Math.max(maxSum, i);
            }
        } else {
            for(int i : arr) {
                sum += i;
                if(sum < 0) {sum = 0;}
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;

    }

    // Sum of triplets = k
    public static void _3sum(int[] arr, int X, int n) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            set = new HashSet<>();
            for(int j=i+1; j<n; j++) {
                int num = X -(arr[i] + arr[j]);
                if(!set.isEmpty() && set.contains(num)) {
                    ArrayList<Integer> temp = new ArrayList<>(
                            List.of(arr[i], arr[j], num)
                    );
                    Collections.sort(temp);
                    res.add(temp);
                }
                set.add(arr[j]);
            }
        }

        System.out.println(res);
    }

    public static void _3sum_opt(int[] arr, int X, int n) {

        Arrays.sort(arr);
        int dist = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {

            if(i>0 && arr[i] == arr[i-1]) {continue;}
            int j=i+1, k=n-1;
            while(j<k) {
                int sum = (arr[i]+arr[j]+arr[k]);
                int currDist = X-sum;
                if(currDist != 0) {
                    dist = Math.min(dist, Math.abs(currDist));
                }

                if(currDist > 0) {
                    k--;
                } else if(currDist < 0){
                    j++;
                } else {
                    j++; k--;
                }
            }
        }

        System.out.println(X-dist);


    }


    public static void main(String[] args) {
//        int[] arr = {-1,-2,-3,-4};
//        System.out.println(maxSubarraySum(arr, arr.length));

//        int[] arr = {1, 2, 3, 4, -5, 7, 5};
        int[] arr = {-1,2,1,-4};
        _3sum_opt(arr, 1, arr.length);


    }
}
