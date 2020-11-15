package algorithmPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 백준 직사각형에서 탈출
 * https://www.acmicpc.net/problem/1085 
 */

public class EscapeR {

	public static void main(String[] args) throws IOException {
		int x = 0, y = 0, w = 0, h = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		x = Integer.parseInt(line[0]);
		y = Integer.parseInt(line[1]);
		w = Integer.parseInt(line[2]);
		h = Integer.parseInt(line[3]);
		
		int distance = x;
		distance = Math.min(distance, h-y);
		distance = Math.min(distance, w-x);
		distance = Math.min(distance, y);
		
		bw.write(distance + "\n");
		bw.flush();
		bw.close();
	}
}
