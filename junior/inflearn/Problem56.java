package junior.inflearn;

import java.util.Scanner;

public class Problem56 {

    public static void main(String[] args) {
        int n,m;
        int[][] arr;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m][3];
        for(int i=0; i<m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        Adjacent adjacent = new Adjacent(n, m, arr);
        adjacent.createAdjacent();
        adjacent.printAdjacent();
    }
}

class Adjacent {

    private int n;
    private int m;
    private int[][] arr;
    int[][] adjacent;

    public Adjacent(int n, int m, int[][] arr) {
        this.n = n;
        this.m = m;
        this.arr = arr;
        this.adjacent = new int[n][n];
    }

    void createAdjacent() {
        for(int i=0; i<arr.length; i++) {
            adjacent[arr[i][0]-1][arr[i][1]-1] = arr[i][2];
        }
    }

    void printAdjacent() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(adjacent[i][j] + " ");
            }
            System.out.println();
        }
    }
}
