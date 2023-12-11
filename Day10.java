package Practise;

public class Day10 {

    public static int merge(int[] arr, int si, int mid, int ei) {
        int i = si, j = mid;
        int ni = 0;
        int[] temp = new int[ei-si+1]; int k=0;

        while(i<mid && j<=ei) {
            if(arr[i] > arr[j]) {
                ni = ni + (mid-i);
                temp[k] = arr[j];
                j++;
            } else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }

        while(i<mid) {
            temp[k++] = arr[i++];
        }
        while(j<=ei) {
            temp[k++] = arr[j++];
        }

        k=0;
        for(int idx=si; idx<=ei; idx++) {
            arr[idx] = temp[k++];
        }

        return ni;
    }

    public static int mergeSort(int[] arr, int si, int ei) {
        int ni = 0;

        if(si == ei) {
            return 0;
        }

        if(ei>si){
            int mid = si + (ei - si) / 2;
            ni = mergeSort(arr, si, mid);
            ni += mergeSort(arr, mid + 1, ei);
            ni += merge(arr, si, mid+1, ei);
        }
        return ni;
    }

    public static int countInv(int[] arr, int N) {
        return mergeSort(arr, 0, N-1);
    }


    public static void printMatrix(int[][] matr) {
        for(int[] row : matr) {
            for(int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    public static void rotateArr(int[] arr, int si, int ei) {
        while(si<ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;

            si++; ei--;
        }
    }
    public static void rotate90(int[][] matrix) {
        // rotate each row of the matrix
        for(int[] row : matrix) {
            rotateArr(row, 0, row.length-1);
        }

        // transpose of the matrix
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(i > j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        printMatrix(matrix);
    }

    public static void main(String[] args) {
//        int[] arr = {468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323};
//        System.out.println("Inversion count: " + countInv(arr, arr.length));

        int[][] matrix = { {1,2,3},{4,5,6},{7,8,9}};
        rotate90(matrix);
    }
}


