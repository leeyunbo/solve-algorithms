package algorithmPractice;

/*
 * https://www.acmicpc.net/status?user_id=servers1&problem_id=10814&from_mine=1
 * 백준 나이 순 정렬 
 * Collections.sort의 정렬알고리즘은 MergeSort이므로 Stable한 정렬이다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgeStableSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Person> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			list.add(new Person(Integer.parseInt(line[0]), line[1]));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<n; i++) {
			bw.write(list.get(i).age + " " + list.get(i).name + "\n");
		}
		bw.flush();
		bw.close();
	}

}

class Person implements Comparable<Person>{
	int age;
	String name; 
	
	public Person(int _age, String _name) {
		age = _age;
		name = _name; 
	}

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		if(this.age < arg0.age) return -1;
		else if(this.age > arg0.age) return 1;
		else return 0;
	}
	
	
}