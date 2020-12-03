/*
* https://www.acmicpc.net/problem/11053
* 백준 가장 긴 증가하는 부분 수열 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = 0;
		int[] numbers;
		int[] cnts;
		
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");	
		numbers = new int[N];
		cnts = new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(line[i]);
		}
		
		// main logic 
		Arrays.fill(cnts, 1);
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(numbers[i] > numbers[j]) cnts[i] = Math.max(cnts[i], cnts[j] + 1);
			}
		}
		
		Arrays.sort(cnts);
		System.out.println(cnts[N-1]);
	}
}
