package algorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 백준 통계학
 * https://www.acmicpc.net/problem/2108
 */

public class Statistics {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		double average = 0; 
		int r_average = 0;
		int middle = 0;
		int common = 0, b_time = 0, t_time = 0, order = 0, temp = 0, before = 4001;
		int range = 0;
		int cnt = 0;
		
		cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			list.add(Integer.parseInt(br.readLine()));
			average += list.get(i);
		}
		Collections.sort(list);
		
		//산술 평균
		r_average = (int) Math.round(average / list.size());
		
		//중앙값 
		middle = list.get(list.size()/2);
		
		//범위 
		range = list.get(list.size()-1) - list.get(0);	
		
		//최빈값 : 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
		for(int i = 0; i < list.size(); i++) {
			temp = list.get(i);
			if(temp == before) t_time++;
			else t_time = 1;
			
			if(t_time > b_time) {
				b_time = t_time; 
				common = temp;
				order = 1;
			}
			else if(t_time == b_time) if(++order == 2) common = temp; 
			
			before = temp; 
		}
				
		System.out.println(r_average +  "\n" + middle + "\n" + common + "\n" + range);
	}
	
	

}


