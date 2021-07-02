package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 여러 단위의 동전이 주어질 때 가장 최소의 동전 갯수로 거스름돈을 거슬러주는 경우를 구하시오
 * 동전의 갯수, 동전의 가치, 거스름돈이 주어진다.
 */

public class Problem93 {

    public static void main(String[] args) {
        int n, limit;
        int[] coins;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = sc.nextInt();
        }
        limit = sc.nextInt();

        CoinExchanger coinExchanger = new CoinExchanger(coins, limit);
        coinExchanger.mainLogic();
    }
}

class CoinExchanger {

    private int limit;
    private int[] coins;
    private int[] dp;

    public CoinExchanger(int[] coins, int limit) {
        this.coins = coins;
        this.limit = limit;
        this.dp = new int[limit+1];
    }

    void mainLogic() {
        for(int i=0; i<=limit; i++) {
            dp[i] = i % coins[0] > 0 ? 654321 : i / coins[0];
        }
        System.out.println(dp());
    }

    int dp() {
        for(int i=1; i<coins.length; i++) {
            for(int j=0; j<=limit; j++) {
                if(j>=coins[i] && dp[j-coins[i]] != 654321) {
                    dp[j] = dp[j-coins[i]] + 1;
                }
            }
        }

        return dp[limit];
    }
}
