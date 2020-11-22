package algorithmPractice;

/*
* https://www.acmicpc.net/problem/1427
* 백준 소트인사이드
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortInSide {
	static StringBuffer n;
	static StringBuffer sorted;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = new StringBuffer(br.readLine());
		mergeSort(0, n.length()-1);	
		System.out.print(n);
	}
	
	private static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	private static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		sorted = new StringBuffer();
		
		while(l <= mid && r <= right) {
			if((int) n.charAt(l) <= (int) n.charAt(r)) {
				sorted.append(n.charAt(r++));
			}
			else {
				sorted.append(n.charAt(l++));
			}
		}
		
		while(l <= mid) {
			sorted.append(n.charAt(l++));
		}
		
		while(r <= right) {
			sorted.append(n.charAt(r++));
		}
		
		for(int i=left, j=0; i<=right; i++, j++) {
			n.replace(i, i+1, Character.toString(sorted.charAt(j)));
		}
	}
}
