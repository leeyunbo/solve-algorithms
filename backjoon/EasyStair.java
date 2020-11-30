package algorithmPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * https://www.acmicpc.net/problem/10844
 * 백준 쉬운 계단 수   
 */

public class EasyStair {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][10];
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		
		for(int i=2; i<=n; i++) {
			for(int l=0; l<=9; l++) {
				if(l==0) dp[i][l] = dp[i-1][l+1] % 1000000000;
				else if(l==9) dp[i][l] = dp[i-1][l-1] % 1000000000;
				else dp[i][l] = (dp[i-1][l-1] + dp[i-1][l+1]) % 1000000000;
			}
		}
		
		long result = 0;
		for(int l=0; l<=9; l++) {
			result += dp[n][l];
		}
		
		bw.write(result % 1000000000+"\n");
		bw.flush();
		bw.close();
		
		
	}

}
