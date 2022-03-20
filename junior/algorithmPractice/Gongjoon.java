package algorithmPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 백준 베르트랑 공준
 * https://www.acmicpc.net/problem/4948
 * 
 * n이 주어졌을 때,n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하여라.
 * 소수는 적어도 하나 존재한다. 
 */

public class Gongjoon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int input = Integer.parseInt(br.readLine());
			int total = 0;
			if(input == 0) break;
			
			for(int i = input+1; i <= input*2; i++) {
				boolean isPrime = true;
				
				if(i != 1) {
					for(int j = 2; j <= Math.sqrt(i); j++) {
						if(i % j == 0) {
							isPrime = false;
							break;
						}
					}
				}
				else isPrime = false;
				
				if(isPrime) {
					total++;
				}
			}
			
			bw.write(total + "\n");	
		}
		bw.flush();
		bw.close();

	}

}
