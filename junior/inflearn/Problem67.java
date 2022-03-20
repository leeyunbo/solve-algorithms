package junior.inflearn;

/**
 * 이항계수를 구하시오.
 * nCr = n-1Cr-1 + n-1Cr
 * (nCr = 특정 숫자를 꼭 포함하는 경우, n-1에서 r-1(특정 숫자 포함)을 고르는 경우(n-1Cr-1) + 특정 숫자를 포함하지 않는 경우(n-1Cr))
 */

import java.util.Scanner;

public class Problem67 {

    public static void main(String[] args) {
        int n, r;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();

        BinomialCoefficient binomialCoefficient = new BinomialCoefficient(n,r);
        System.out.println(binomialCoefficient.DFS(n,r));
    }
}


class BinomialCoefficient {

    private int[][] dp;
    private int r;
    private int n;
    public int result;


    public BinomialCoefficient(int n, int r) {
        this.n = n;
        this.r = r;
        dp = new int[n+1][n+1];
    }

    public int DFS(int n, int r) {
        if(n < r) return 0;
        if(r == 0 || (n == r)) return 1;
        if(dp[n][r] > 0) return dp[n][r];

        return dp[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }
}
