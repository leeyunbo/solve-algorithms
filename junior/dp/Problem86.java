package junior.dp;

/**
 * 철수는 N개의 돌로 이루어진 다리를 건너 반대편으로 가려고 한다.
 * 이때 한번에 1, 2칸의 돌만 건널 수 있을 떄 모든 경우의 수는?
 */

import java.util.Scanner;

public class Problem86 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StoneBridge stoneBridge = new StoneBridge(sc.nextInt());
        stoneBridge.dp();

    }
}


class StoneBridge {

    private int n;
    private int dp[];

    public StoneBridge(int n) {
        this.n = n;
        dp = new int[n+2];
    }

    void dp() {
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n+1]);
    }
}
