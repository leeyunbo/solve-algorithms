package junior.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 자연수로 이루어진 수열이 주어질 때
 * 최대 증가 수열을 구하시오.
 */

public class Problem87 {

    public static void main(String[] args) {
        int n;
        int[] numbers;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];

        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        LIS lis = new LIS(numbers);
        lis.mainLogic();
    }
}


class LIS {

    private int[] numbers;
    private int[] dp;

    public LIS(int[] numbers) {
        this.numbers = numbers;
        dp = new int[numbers.length];
        Arrays.fill(dp, 1);
    }

    void mainLogic() {
        System.out.println(dp());
    }

    int dp() {
        for(int i=1; i<numbers.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);

        return dp[numbers.length-1];
    }
}
