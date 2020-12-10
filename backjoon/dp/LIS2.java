package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/11054
 * 백준 가장 긴 바이토닉 부분 수열   
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp;
		int[] data; 
		
		int n = Integer.parseInt(br.readLine());
		data = new int[n];
		dp = new int[n][3]; 
		
		String[] line = br.readLine().split(" "); 
		for(int i=0; i<line.length; i++) {
			data[i] = Integer.parseInt(line[i]);
		}
		
		dp[0][0] = dp[0][1] = dp[0][2] = 1;
		
		for(int i=1; i<n; i++) {
			int increase_max = 0;
			int decrease_max = 0;
			int vitonic_max = 0;
			for(int j=i; j>=0; j--) {
				// 증가 
				if(data[j] < data[i]) increase_max = Math.max(dp[j][0], increase_max);
				// 감소, 증가하다가 감소하는 경우 
				if(data[j] > data[i]) {
					decrease_max = Math.max(Math.max(dp[j][1], dp[j][2]), decrease_max);
					vitonic_max = Math.max(dp[j][0], vitonic_max);
				}
			}
			
			dp[i][0] = increase_max + 1;
			dp[i][1] = decrease_max + 1;
			dp[i][2] = vitonic_max + 1;
		}
		
		int result = 0;
		for(int i=0; i<n; i++) {
			result = Math.max(result,Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));
		}
		
		System.out.println(result);
	}
}
