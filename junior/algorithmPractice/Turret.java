package algorithmPractice;

/*
 * 백준 1002번 터렛 
 * https://www.acmicpc.net/problem/1002
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Turret {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
		
			String[] line = br.readLine().split(" ");
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int r1 = Integer.parseInt(line[2]);
			int x2 = Integer.parseInt(line[3]);
			int y2 = Integer.parseInt(line[4]);
			int r2 = Integer.parseInt(line[5]);
			
			double dist = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
			
			if(dist == 0) {
				// 두 점 사이의 위치가 같고,반지름이 같으면 아예 겹치는 원이기 때문에 모든 위치에 존재할 수 있
				if (r1 == r2) {
					bw.write("-1\n");
				}
				// 두 점 사이의 위치가 같고, 반지름이 다르면 아예 겹치지 않는 원이기 때문에 성립할 수 없음 
				else bw.write("0\n");
			}
			else {
				// 두 점 사이의 거리가 반지름 차보다 작거나,반지름 합보다 큰 경우 성립할 수 없음 
				if (dist < (r2 - r1) * (r2 - r1) || dist > (r2 + r1) * (r2 + r1)) {
					bw.write("0\n");
				}
				// 두 점 사이의 거리가 반지름 차와 같거나, 반지름 합과 같은 경우 한개가 존재할 수 있음 
				else if (dist == (r2 - r1) * (r2 - r1) || dist == (r2 + r1) * (r2 + r1)) {
					bw.write("1\n");
				}
				//두 점 사이의 거리가 반지름 차보다 크거나, 반지름 합보다 작은 경우 두개가 존재할 수 있
				else if (dist > (r2 - r1) * (r2 - r1) && dist < (r2 + r1) * (r2 + r1)) {
					bw.write("2\n");
				}
			}

			
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
