package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/12865
 * 백준 평범한 배낭   
 */

import java.io.IOException;
import java.util.Scanner;

public class Bag {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        int[][] dp = new int[n+1][k+1];
        int max = 0;
        for(int i = 1; i < n+1; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for(int idx = 1; idx <= n; idx++) {
            for(int weight = 1; weight <= k; weight++) {
                if(w[idx] <= weight)
                    dp[idx][weight] = Math.max(v[idx] + dp[idx-1][weight - w[idx]], dp[idx-1][weight]);
                else
                    dp[idx][weight] = dp[idx-1][weight];
                max = Math.max(dp[idx][weight], max);
            }
        }
        System.out.println(max);
    }

}

