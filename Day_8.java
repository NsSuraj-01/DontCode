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

    // big- "cbabc", small-"abc" -> ans=2
    public static void perm(String big, String small) {
        // sliding window approach
        return;
    }

    public static void printMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void zero_matrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {

        int col0=1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat.get(i).get(j) == 0) {
                    mat.get(i).set(0,0);
                    if(j!=0){
                        mat.get(0).set(j, 0);
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(mat.get(0).get(j) == 0 || mat.get(i).get(0) == 0) {
                    mat.get(i).set(j, 0);
                }
            }
        }

        if(mat.get(0).get(0) == 0) {
            for(int i=1; i<m; i++) {
                mat.get(0).set(i, 0);
            }
        }

        if(col0 == 0) {
//            for(ArrayList<Integer> row : mat) {
//                row.set(0,0);
//            }
            for(int i=0; i<n; i++) {
                mat.get(i).set(0,0);
            }
        }

        printMatrix(mat, n, m);
    }

    public static void spiralMatrix(int[][] mat, int n, int m) {
        int sr = 0, er = n-1;
        int sc = 0, ec = m-1;

        while(sr<=er && sc<=ec) {
            // top
            for(int i=sc; i<=ec; i++) {
                System.out.print(mat[sr][i] +" ");
            }
            // right
            for(int i=sr+1; i<=er; i++) {
                System.out.print(mat[i][ec]+" ");
            }
            // bottom
            for(int i=ec-1; i>=sc; i--) {
                if(sr == er) {break;}
                System.out.print(mat[er][i]+" ");
            }
            // left
            for(int i=er-1; i>=sr+1; i--) {
                if(sc == ec) {break;}
                System.out.print(mat[i][sc]+" ");
            }

            sr++; sc++;
            er--; ec--;
        }
    }


    public static void main(String[] args) {
//        triangularPattern(5);
//        int[] arr = {2,1,0,2,1,0,2,1};
//        subArrSum3(arr, 3);
//        ArrayList<Integer> list = new ArrayList<>(List.of(2,1,0,2,1,0,2,1));
//        sortArray(list,list.size());
//        int[] prices = {7,1,5,4,3,6};
//        stocks(prices);

//        ArrayList<ArrayList<Integer>> mat = new ArrayList<>(Arrays.asList(
//                new ArrayList<>(List.of(2,4,3)),
//                new ArrayList<>(List.of(1,0,0))
//        ));
//
//        zero_matrix(mat, 2, 3);

//        int[][] matrix = {  {13,32,8},
//                            {37,14,26},
//                            {29,16,45},
//                            {32,23,29},
//                            {38,24,17}};

//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1,3,7,9},{10,12,15,17},{19,20,21,50}};
        spiralMatrix(matrix, matrix.length, matrix[0].length);

    }
}