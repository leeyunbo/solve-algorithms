package algorithmPractice;

/*
 * 백준 직각삼각형  
 * https://www.acmicpc.net/problem/4153
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RightAngledTriangle {

	public static void main(String[] args) throws IOException {
		String result = "";
		int[] numbers = new int[3];
		int max = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String[] line = br.readLine().split(" ");
			numbers[0] = Integer.parseInt(line[0]);
			numbers[1] = Integer.parseInt(line[1]);
			numbers[2] = Integer.parseInt(line[2]);
			
			if(numbers[0] == 0 && numbers[1] == 0 && numbers[2] == 0) break;
			
			max = Math.max(Math.max(numbers[0], numbers[1]),numbers[2]);
			
			if(max == numbers[0]) {
				result = (Math.pow(max, 2) == Math.pow(numbers[1], 2) + Math.pow(numbers[2], 2)) ? "right" : "wrong";
			} 
			else if(max == numbers[1]) {
				result = (Math.pow(max, 2) == Math.pow(numbers[0], 2) + Math.pow(numbers[2], 2)) ? "right" : "wrong";
			}
			else {
				result = (Math.pow(max, 2) == Math.pow(numbers[0], 2) + Math.pow(numbers[1], 2)) ? "right" : "wrong";
			}
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
