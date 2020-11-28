package algorithmPractice;

/*
* https://www.acmicpc.net/problem/1149
* 백준 RGB 거리
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RGBRoad {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] cost;
		int[][] dp;
		int n;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		dp = new int[n][3];
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			cost[i][0] = Integer.parseInt(line[0]);
			cost[i][1] = Integer.parseInt(line[1]);
			cost[i][2] = Integer.parseInt(line[2]);
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for(int i=1; i<n; i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
		    dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
		    dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		bw.write(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]) + "\n");
		bw.flush();
		bw.close();		
	}
}
