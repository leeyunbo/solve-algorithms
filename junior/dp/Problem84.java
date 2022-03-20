package junior.dp;

/**
 * Nm의 네트워크 선을 1m, 2m로 나눠야한다.
 * 순서가 다르면 다른 경우라고 할 때 Nm의 선을 1m, 2m로 나누는 모든 경우의 수를 구하시오.
 */


import java.util.Scanner;

public class Problem84 {

    public static void main(String[] args) {
        int N;

        Scanner sc = new Scanner(System.in) ;
        N = sc.nextInt();

        NetworkLineTopDown networkLine = new NetworkLineTopDown(N);
        networkLine.mainLogic();
    }
}

class NetworkLineTopDown {

    private int N;
    private int dp[];

    public NetworkLineTopDown(int N) {
        this.N = N;
        this.dp = new int[N+1];
    }

    void mainLogic(){
        System.out.println(dp(N));
    }


    int dp(int n) {
        if(n <= 2) return n;

        if(dp[n] > 0) return dp[n];

        return dp[n] = dp(n-1) + dp(n-2);
    }
}
