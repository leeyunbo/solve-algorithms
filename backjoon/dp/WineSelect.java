package algorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * https://www.acmicpc.net/problem/2156
 * 백준 포도주 시
 */

public class WineSelect {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int[] wine;
		int[] dp;
		int n = Integer.parseInt(br.readLine());
		
		wine = new int[n]; 
		dp = new int[n];
		for(int i=0; i<n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = wine[0];
		if(n >= 2) dp[1] = wine[0] + wine[1];
		if(n >= 3) dp[2] = Math.max(wine[2] + dp[0],Math.max(wine[2] + wine[1], dp[1]));
		
		if(n==1) {
			System.out.println(dp[0]);
			return;
		}
		if(n==2) {
			System.out.println(dp[1]);
			return;
		}
		
		for(int i=3; i<n; i++) {
			dp[i] = Math.max(dp[i-1],Math.max(wine[i] + wine[i-1] + dp[i-3], wine[i] + dp[i-2]));
		}
		
		System.out.println(dp[n-1]);
	}
}
