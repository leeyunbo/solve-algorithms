package dp;

import java.util.Scanner;

/**
 * (1, 1) 격자에서 (N, N) 격자로 이동한다고 할 때, 한칸 이동할 때마다 map[i][j] 만큼의 에너지가 소모된다.
 * (N,N) 까지 갈 수 있는 최단거리 중에 에너지가 가장 적게 소모되는 경우의 총 에너지 소모량을 구하시오.
 */

public class Problem91 {

    public static void main(String[] args) {
        int n;
        int[][] map;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        AlibabaTopDown alibabaTopDown = new AlibabaTopDown(map, n);
        alibabaTopDown.mainLogic();
    }
}


class AlibabaTopDown {

    private int[][] map;
    private int[][] dp;
    private int n;

    public AlibabaTopDown(int[][] map, int n) {
        this.map = map;
        this.n = n;
        dp = new int[n][n];
    }

    void mainLogic() {
        System.out.println(dp(n-1, n-1));
    }

    int dp(int left, int right) {
        if(dp[left][right] > 0) return dp[left][right];

        if(left == 0 && right == 0) return map[0][0];
        if(left == 0) return dp[left][right] = map[left][right] + dp(left, right-1);
        if(right == 0) return dp[left][right] = map[left][right] + dp(left-1, right);

        return dp[left][right] = map[left][right] + Math.min(dp(left-1, right), dp(left, right-1));
    }
}
