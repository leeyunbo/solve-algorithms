package algorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 소수 
https://www.acmicpc.net/problem/2581 

1. 제곱근 까지만 나눌 것
예를 들어 81 같은 경우 (1X81, 3X27, 9X9 ...) -> 제곱근 까지만 나눠봐도 1, 3, 9, 27, 81 약수를 모두 구할 수 있음
따라서 제곱근 까지만 나눠도 약수를 모두 구하는 것이기 때문에(나눠지는 수) 소수를 판별할 수 있음

2. 에라토스테네스의 체
2부터 n까지의 숫자중에서 에라토스테네스의 체로 소수를 찾으려면, 2부터 시작해 n까지의 자연수를 차례로 쓴다. (2, 3, 4, ..., n)
그리고 2 이외의 2의 배수를 지운다(p=2). 이때 2가 최초의 소수가 된다.
그 다음 소수인 3을 제외한 3의 배수를 지운다(p=3).
이 방법을 다음에 지울 소수, 즉 p의 제곱이 n 보다 커질 때까지, 이 방법을 계속한다(p2≥n).
 */

public class PrimeNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int M = 0, N = 0;
		int least = -1, total = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		
		for(int i = M; i <= N; i++) {
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
				if(least == -1) least = i;
				total += i;
			}
			
		}
		
		
		if(least == -1) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(total);
		System.out.println(least);
	}
}
