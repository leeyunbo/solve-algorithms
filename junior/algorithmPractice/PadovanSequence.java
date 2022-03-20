package algorithmPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * https://www.acmicpc.net/problem/9461
 * 백준 파도반 수열 문제 풀이    
 */

public class PadovanSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1; 
		dp[3] = 1;
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			if(dp[N] > 0) {
				bw.write(dp[N] + "\n");
				continue;
			}
			for(int j=4; j<=N; j++) {
				if(dp[j] > 0) continue;
				dp[j] = dp[j-3] + dp[j-2];
			}
			bw.write(dp[N] + "\n");
		}
		bw.flush();
		bw.close();
	}

}
