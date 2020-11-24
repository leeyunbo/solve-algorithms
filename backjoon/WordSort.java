package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/1181
 * 백준 단어 정렬 문제 풀이 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * 길이가 짧은 것부터, 길이가 같으면 사전 순으로
 */

public class WordSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		TreeSet <Word> list = new TreeSet<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			list.add(new Word(word));
		}
		
		while(!list.isEmpty()) {
			bw.write(list.pollFirst().word + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}

class Word implements Comparable<Word>{
	String word;
	
	public Word(String _word) {
		word = _word;
	}

	@Override
	public int compareTo(Word arg0) {
		// TODO Auto-generated method stub
		if(word.length() < arg0.word.length()) {
			return -1;
		}
		else if(word.length() > arg0.word.length()) {
			return 1;
		}
		else {
			return word.compareTo(arg0.word);
		}
	}
	
	@Override
	public String toString() {
		return word;
	}
}
