package junior.dp;

/**
 * 철수는 한번에 1, 2계단을 오를 수 있다.
 * 만약 N계단 까지 올라간다고 할 때, 방법의 수를 구하시오.
 */

import java.util.Scanner;

public class Problem85 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UpStair upStair = new UpStair(sc.nextInt());
        upStair.mainLogic();
    }
}

class UpStair {

    private int N;
    private int dp[];

    public UpStair(int N) {
        this.N = N;
        dp = new int[N+1];
    }

    void mainLogic() {
        System.out.println(dp(N));
    }

    int dp(int n) {
        if(dp[n] > 0) return dp[n];
        if(n == 1 || n == 2) return n;

        return dp[n] = dp(n-2) + dp(n-1);
    }
}
