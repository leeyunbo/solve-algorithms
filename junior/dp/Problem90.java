package junior.dp;

/**
 * (1, 1) 격자에서 (N, N) 격자로 이동한다고 할 때, 한칸 이동할 때마다 junior.map[i][j] 만큼의 에너지가 소모된다.
 * (N,N) 까지 갈 수 있는 최단거리 중에 에너지가 가장 적게 소모되는 경우의 총 에너지 소모량을 구하시오.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Problem90 {

    public static void main(String[] args) {

        int n;
        int[][] map;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n+1][n+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        AlibabaBottomUp alibabaBottomUp = new AlibabaBottomUp(map, n);
        alibabaBottomUp.mainLogic();
    }
}

class AlibabaBottomUp {

    private int[][] map;
    private int[][] dp;
    private int n;

    public AlibabaBottomUp(int[][] map, int n) {
        this.map = map;
        this.n = n;
        dp = new int[n+1][n+1];
    }

    void mainLogic() {
        for(int i=0; i<n+1; i++) {
            Arrays.fill(dp[i], 654321);
        }
        System.out.println(dp());
    }

    int dp() {
        dp[1][1] = map[1][1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(i==1&&j==1) dp[i][j] = map[i][j];
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + map[i][j];
                }
            }
        }

        return dp[n][n];
    }
}
