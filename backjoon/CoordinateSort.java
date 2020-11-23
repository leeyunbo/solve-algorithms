package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/11651
 * 백준 좌표 정렬하기    
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CoordinateSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Coordinate> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			list.add(new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
		}
		Collections.sort(list);
		
		for(int i=0; i<n; i++) {
			bw.write(list.get(i).toString() + "\n");
		}
		bw.flush();
		bw.close();
	}
}


class Coordinate implements Comparable<Coordinate> {
	int x, y;
	
	public Coordinate(int _x, int _y) {
		x = _x;
		y = _y;
	}

	@Override
	public int compareTo(Coordinate arg0) {
		// TODO Auto-generated method stub
		if(this.y < arg0.y) return -1;		
		else if(this.y > arg0.y) return 1;
		else {
			if(this.x < arg0.x) return -1;
			else if(this.x > arg0.x) return 1;
			else return 0;
		}
	}
	
	@Override 
	public String toString() {
		return x + " " + y;
	}
}
