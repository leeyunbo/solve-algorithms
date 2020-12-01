package algorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WineSelect {
	
	static int result = 0;
	static int[] wine;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		wine = new int[n]; 
		for(int i=0; i<n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		select(-1, 0, 0);
		
		System.out.println(result);
	}
	
	
	
	private static void select(int idx, int continuous, int total) {
		if(continuous == 3) return; 
		if(idx == wine.length-1) {
			result = Math.max(result, total);
			return; 
		}
	
		for(int i=idx+1; i<wine.length; i++) {
			if(i == idx + 1) select(i, continuous + 1, total + wine[i]);
			else select(i, 0, total + wine[i]);
		}
		
		
	}

}
