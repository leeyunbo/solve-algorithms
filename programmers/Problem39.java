/**
https://programmers.co.kr/learn/courses/30/lessons/42898 
*/
import java.util.*;

class Solution {
    private static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {        
        int[][] map = new int[m+1][n+1]; 
        long[][] dp = new long[m+1][n+1];
        long[][] dp2 = new long[m+1][n+1];
        
        for(int i=0; i<puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = 654321;
            map[puddles[i][0]][puddles[i][1]] = 1;
        }
        
        for(int i=0; i<m+1; i++) {
            dp[i][0] = 654321;
        }
        
        for(int i=0; i<n+1; i++) {
            dp[0][i] = 654321;
        }
        
        dp[1][1] = 0;
        dp2[1][1] = 1;
        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(map[i][j] == 1 || (i==1 && j==1)) continue;
                if(dp[i-1][j] == dp[i][j-1]) dp2[i][j] = (dp2[i-1][j] % MOD) + (dp2[i][j-1] % MOD); 
                else dp2[i][j] = dp[i-1][j] < dp[i][j-1] ? (dp2[i-1][j] % MOD) : (dp2[i][j-1] % MOD);
                dp[i][j] = Math.min((dp[i-1][j] % MOD), (dp[i][j-1] % MOD)) + 1;
            }
        }
        
        return (int) dp2[m][n] % MOD;
    }
}
