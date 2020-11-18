package algorithmPractice;

/*
 * 택시 기하학 
 * https://www.acmicpc.net/problem/3053
 * 유클리드 기하학에서 원은 우리가 알고있는 원이지만, 택시 기하학에서는 정사각형을 나타냄(지름은 정사각형의 대각선) 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxicabGeometry {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double r = Double.parseDouble(br.readLine());
		
		System.out.println(r*r*3.14159265358979323846);
		System.out.println(r*r*2);
	}

}
