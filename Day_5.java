package Practise;

import java.util.*;

public class Day_5 {

    // 1. Majority elem -> time = O(N)
    public static int majorElem(int[] A, int N) {
        int elem = A[0];
        int count = 1;

        for(int i=1; i<N; i++) {
            if(count == 0) {
                count=1;
                elem = A[i];
            }
            else if(A[i] == elem) {count++;}
            else {count--;}
        }

        return count>0 ? elem : -1;
    }

    // 2. Stock buy and sell-II
    // time -> O(N)

    public static void maxProfit(int[] A, int N) {
        int profit=0; int i=0;

        while(i<N) {
            // next local Min -> to buy the stock
            while (i < N-1 && A[i] >= A[i + 1]) {
                i++;
            }
            int min = A[i];
            i++;

            // next Local Max -> to sell the stock
            while(i<N-1 && A[i] <= A[i+1]) {
                i++;
            }
            profit += (i < N) ? (A[i] - min) : 0;
            i++;
        }

        System.out.println("Total profit: " + profit);
    }


    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        maxProfit(arr, arr.length);
    }
}
