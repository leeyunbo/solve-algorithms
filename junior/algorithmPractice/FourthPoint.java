package algorithmPractice;

/*
 * 백준 네 번째 점 
 * https://www.acmicpc.net/problem/3009
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FourthPoint {
	public static void main(String[] args) throws IOException {
		int x1, y1, x2, y2, x3, y3, x4, y4; 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		x1 = Integer.parseInt(line[0]);
		y1 = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		x2 = Integer.parseInt(line[0]);
		y2 = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		x3 = Integer.parseInt(line[0]);
		y3 = Integer.parseInt(line[1]);
		
		x4 = x1^x2^x3;
		y4 = y1^y2^y3;
		
		bw.write(x4 + " " + y4 + "\n");
		bw.flush();
		bw.close();
	}
}
