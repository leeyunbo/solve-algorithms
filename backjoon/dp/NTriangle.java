package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/1932
 * 백준 정수 삼각형   
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NTriangle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] dp;
		int[][] cost;
		int n, temp = 2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		cost = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<line.length; j++) {
				cost[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		dp[0][0] = cost[0][0]; 
		for(int i=1; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				if(j==0) dp[i][j] = dp[i-1][j] + cost[i][j];
				else if(j == i) dp[i][j] = dp[i-1][j-1] + cost[i][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + cost[i][j];
			}
		}
		
		int result = -1; 
		for(int i=0; i<n; i++) {
			result = Math.max(dp[n-1][i], result);
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}
