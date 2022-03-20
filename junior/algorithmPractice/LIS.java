package algorithmPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * https://www.acmicpc.net/problem/11053
 * 백준 가장 긴 증가하는 부분 수열
 * 현재 위치를 i라고 해보자. 
 * [1...i-1] 위치의 값 중 가장 긴 증가하는 부분 수열 길이를 가진 값의 idx를 L이라고 했을 때
 * junior.dp[i] = junior.dp[L] + 1 이다.
 */

public class LIS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n,result = 1;
		int input[], dp[];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		
		input = new int[n];
		dp = new int[n];
		for(int i=0; i<n; i++) {
			input[i] = Integer.parseInt(line[i]);
		}
		
		dp[0] = 1;
		for(int temp=1; temp<n; temp++) {
			int largest = 0;
			for(int other=temp-1; other>=0; other--) {
				if(input[temp] > input[other]) {
					largest = Math.max(dp[other], largest);
				}
			}
			dp[temp] = largest + 1;
			result = Math.max(dp[temp], result);
		}
		
		System.out.println(result);
	}
}
