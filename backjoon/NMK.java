/*
* https://www.acmicpc.net/problem/18290
* 백준 NM과 K (1)
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	
	static int N,M,K;
	static int result = -1000000000;
	static int[][] array; 
	static LinkedList<int[]> selectNums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		K = Integer.parseInt(line[2]);
		
		selectNums = new LinkedList<int[]>();
		array = new int[N][M];
		for(int i=0; i<N; i++) {
			line = br.readLine().split(" "); 
			for(int j=0; j<line.length; j++) {
				array[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int[] selectNum = {i, j};
				selectNums.add(selectNum);
				selectK(i,j,array[i][j]);
				selectNums.pollLast();
			}
		}
		
		System.out.println(result);
	}
	
	private static void selectK(int i, int j, int total) {
		// base-case
		if(selectNums.size() == K) {
			result = Math.max(total, result);
			return;
		}
		
		// recursion-case
		for(int nextI = i; nextI < N; nextI++) {
			for(int nextJ = 0; nextJ < M; nextJ++) {
				if(!isPossible(nextI,nextJ)) {
					continue;
				}
				int[] selectNum = {nextI, nextJ};
				selectNums.add(selectNum);
				selectK(nextI, nextJ, total + array[nextI][nextJ]);
				selectNums.pollLast();
			}
		}
	}
	
	private static boolean isPossible(int nextI, int nextJ) {
		for(int[] idxs : selectNums) {
			if((nextI == idxs[0] && nextJ == idxs[1]) || (nextI == idxs[0] && nextJ == idxs[1]-1) || (nextI == idxs[0] && nextJ == idxs[1]+1)) {
				return false;
			}
			
			if((nextI == idxs[0]-1 && nextJ == idxs[1]) || (nextI == idxs[0]+1 && nextJ == idxs[1])) {
				return false;
			}
		}
		
		
		return true;
	}
}
