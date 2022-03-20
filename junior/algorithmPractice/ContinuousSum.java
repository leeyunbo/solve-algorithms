package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/1912
 * 백준 연속합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContinuousSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp, sequence;
        int result = 0;

        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        sequence = new int[n];

        String[] line = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            sequence[i] = Integer.parseInt(line[i]);
        }

        dp[0] = sequence[0];
        result = sequence[0];
        for(int temp=1; temp<n; temp++) {
            dp[temp] = Math.max(dp[temp-1] + sequence[temp], sequence[temp]);
            result = Math.max(result, dp[temp]);
        }

        System.out.println(result);
    }
}
