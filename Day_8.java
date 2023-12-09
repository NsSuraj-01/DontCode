package Practise;

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

    public static void main(String[] args) {
        triangularPattern(5);
    }
}
