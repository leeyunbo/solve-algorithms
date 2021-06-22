package dp;

/**
 * Nm의 네트워크 선을 1m, 2m로 나눠야한다. 
 * 순서가 다르면 다른 경우라고 할 때 Nm의 선을 1m, 2m로 나누는 모든 경우의 수를 구하시오.
 */

import java.util.Scanner;

public class Problem83 {

    public static void main(String[] args) {
        int N;

        Scanner sc = new Scanner(System.in) ;
        N = sc.nextInt();

        NetworkLine networkLine = new NetworkLine(N);
        networkLine.dp();
    }
}


class NetworkLine {

    private int N;
    private int dp[];

    public NetworkLine(int N) {
        this.N = N;
        this.dp = new int[N+1];
    }


    void dp() {
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}
