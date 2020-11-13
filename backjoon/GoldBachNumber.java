package algorithmPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 백준 골드바흐의 추측
 * https://www.acmicpc.net/problem/9020
 */

public class GoldBachNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			StringBuffer result = new StringBuffer();

			for(int j=2; j<n; j++) {
				boolean isPrime = true;
				int distance = 123456;
				for(int k = 2; k <= Math.sqrt(j); k++) {
					if(j % k == 0) {
						isPrime = false;
						break;
					}
				}
					
				if(isPrime && thisIsPrime(n-j)) {
					if(distance > j - (n-j)) {
						distance = j - (n-j);
						result.replace(0, result.length(), j + " " + (n-j) + "\n");
					}
				}
			}
			
			bw.write(result.toString());
			
		}
		
		bw.flush();
		bw.close();
	}
	
	private static boolean thisIsPrime(int n) {
		boolean isPrime = true;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				isPrime = false;
				break;
			}
		}
				
		if(isPrime) return true;
		return false;
	}
}


