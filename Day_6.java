package Practise;

import java.sql.SQLOutput;
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

    // kadane's algo -> T(n) = O(n)
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

    // Sum of triplets = 0 -> O(N^2)
    public static void _3sum(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            set = new HashSet<>();
            for(int j=i+1; j<n; j++) {
                int num = -(arr[i] + arr[j]);
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

    // O(N*logN)
    public static void _3sum_opt(int[] arr, int n, int X) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-2; i++) {
            int curr = arr[i];
            int left = i+1, right = n-1;

            while(left < right) {
                int sum = curr + arr[left] + arr[right] ;
                if(sum == 0){
                    res.add(new ArrayList<>(
                            List.of(curr, arr[left], arr[right])
                    ));
                    left++;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(res);
    }

    // O(N*logN)
    public static void _3sumClosest(int[] arr, int N, int X) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> dist = new ArrayList<>();

        for(int i=0; i<N-2; i++) {
            int curr = arr[i];
            int left = i+1, right = N-1;

            while(left < right) {
                int sum = curr + arr[left] + arr[right] ;
                dist.add(Math.abs(X - sum));
                if(sum == 0){
                    res.add(new ArrayList<>(
                            List.of(curr, arr[left], arr[right])
                    ));
                    left++;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        Collections.sort(dist, Collections.reverseOrder());

        int num = 2;
        int max = dist.get(0);
        for(int i=0; i<dist.size() && num > 1 ; i++) {
            if(max != dist.get(i)) {
                max = dist.get(i);
                num--;
            }
        }

        System.out.println(max);
    }


    public static void main(String[] args) {
//        int[] arr = {-1,-2,-3,-4};
        int[] arr = {1, 2, 3, 4, -5};
//        int[] arr = {-1,2,1,-4};


//        System.out.println(maxSubarraySum(arr, arr.length));

        _3sumClosest(arr,arr.length, 1);


    }
}
