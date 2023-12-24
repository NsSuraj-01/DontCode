package Practise;

import java.util.*;
public class Day_8 {

    // triangular pattern with n rows
    // time->O(n^2)
    public static void triangularPattern(int n) {
        for(int row=1; row<=n; row++) {
            for(int i=1; i<=n-row; i++) {
                System.out.print(" ");
            }
            for(int i=1; i<=2*(row)-1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void leftpattern(int n) {
        for(int row=1; row<=n; row++) {
            for(int i=1; i<=n-row; i++) {
                System.out.print(" ");
            }
            for(int i=1; i<=row; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // longest subArr of sum = k

    // brute-force soln -> O(N^2)
    public static void subArrsum(int[] arr, int k) {
        int N = arr.length;
        int[] pref = new int[N];

        pref[0] = arr[0];
        for(int i=1; i<N; i++) {
            pref[i] = pref[i-1] + arr[i];
        }

        int max_size = 0;
        int size = 0;

        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                if (pref[j] == k) {
                    max_size = Math.max(max_size, j + 1);
                } else if (i > 0 && pref[j] - pref[i - 1] == k) {
                    size = (j - i + 1);
                    max_size = Math.max(max_size, size);
                }
            }
        }

        System.out.println(max_size);
    }

    // better solution -> O(N)
    public static void subArrsum2(int[] arr, long k) {
        int N = arr.length;
        long maxLen = 0;

        //<sum,idx>
        HashMap<Long, Integer> map = new HashMap<>();
        long sum=0;

        for(int i=0; i<N; i++) {
            sum += arr[i];
            if(sum == k) {
                maxLen = Math.max(maxLen, i+1);
            }

            long rem = sum-k;
            if(map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        System.out.println(maxLen);
    }

    // optimal soln -> 2 ptr approach
    // O(N)

    public static void subArrSum3(int[] arr, int k) {
        int left = 0, right = 0;
        int N = arr.length;

        int len = 0;
        int sum = arr[0];
        // left is used for dec size of subArr if size > k
        // right is used for inc the size if size < k
        while(right < N) {
            while(left <= right && sum > k) {
                sum = sum-arr[left];
                left++;
            }

            if(sum == k) {
                len = Math.max(len, right-left+1);
            }

            right++;
            if(right < N) {
                sum += arr[right];
            }

        }
        System.out.println(len);
    }


    public static void sortArray(ArrayList<Integer> arr, int n) {
        // Write your code here.
        int left = 0, right = n-1;

        while(left < right) {

            while(arr.get(right) == 2) {
                right--;
            }
            if(arr.get(left) == 2) {
                int temp = arr.get(right);
                arr.set(right, arr.get(left));
                arr.set(left, temp);

                right--;
            }
            left++;
        }

        // right is at left of 2's
        left=0;
        while(left < right) {
            if(arr.get(left) == 1) {

                while(arr.get(right) == 1) {
                    right--;
                }
                int temp = arr.get(right);
                arr.set(right, arr.get(left));
                arr.set(left, temp);

                right--;
            }
            left++;
        }

        System.out.println(arr);
    }

    public static void stocks(int[] arr) {
        int N = arr.length;
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            min_price = Math.min(arr[i], min_price);
            max_profit = Math.max(max_profit, arr[i]-min_price);
        }

        System.out.println(max_profit);
    }


    public static void main(String[] args) {
//        triangularPattern(5);
//        int[] arr = {2,1,0,2,1,0,2,1};
//        subArrSum3(arr, 3);
//        ArrayList<Integer> list = new ArrayList<>(List.of(2,1,0,2,1,0,2,1));
//        sortArray(list,list.size());
        int[] prices = {7,1,5,4,3,6};
        stocks(prices);
    }
}