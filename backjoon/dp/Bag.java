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
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        int[][] dp = new int[n+1][k+1];
        int max = 0;
        for(int i = 1; i < n+1; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for(int idx = 1; idx < n+1; idx++) {
            for(int bagWeight = 1; bagWeight < k+1; bagWeight++) {
                if(weight[idx] > bagWeight)
                    dp[idx][bagWeight] = dp[idx-1][bagWeight];
                else
                    dp[idx][bagWeight] = Math.max(dp[idx-1][bagWeight], value[idx] + dp[idx-1][bagWeight-weight[idx]]);

                max = Math.max(max, dp[idx][bagWeight]);
            }
        }
        
        System.out.println(max);
    }
}

