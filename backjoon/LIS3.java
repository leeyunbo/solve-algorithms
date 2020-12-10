package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/2565
 * 백준 전깃줄 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int LIS_length = 0, first = 654321;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] line = new int[501];
	    int[] dp = new int[501];
	    
		for(int i=0; i<n; i++) {
			String[] str_line = br.readLine().split(" ");
			int start = Integer.parseInt(str_line[0]);
			int end = Integer.parseInt(str_line[1]);
			line[start] = end;
			first = Math.min(first, start);
		}
		
		// LIS를 구하면 된다. 
		dp[first] = 1;
		for(int temp=first+1; temp<line.length; temp++) {
			if(line[temp] == 0) continue;
			int largest = 0;
			for(int other=temp-1; other>=first; other--) {
				if(line[other] > 0 && (line[other] < line[temp])) largest = Math.max(largest, dp[other]);
			}
			
			dp[temp] = largest + 1;
			LIS_length = Math.max(LIS_length, dp[temp]);
		}
		
		System.out.println(n - LIS_length);
	}
}
