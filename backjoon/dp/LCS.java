package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/9251
 * 백준 LCS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<=str1.length(); i++) dp[i][0] = 0;
        for(int i=0; i<=str2.length(); i++) dp[0][i] = 0;

        int str1_idx = 0;
        int str2_idx = 0;

        for(int i=1; i<=str1.length(); i++) {
            for(int j=1; j<=str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
