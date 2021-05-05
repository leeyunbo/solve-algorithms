import java.util.*;

class Main {
    public int solution(int n, int[][] garden) {
        int answer = 1;
				int total = 0; 
			
				for(int i=0; i<n; i++) {
						for(int j=0; j<n; j++) {
								if(garden[i][j] == 1) total++; 
						}
				}
	
				while(total != n*n) {
						for(int i=0; i<n; i++) {
								for(int j=0; j<n; j++) {
										if(garden[i][j] == answer) total += check(i, j, garden, answer);
								}
						}
						answer++;
				}
			
				
				
			
        return answer-1;
    }
	
	
		public int check(int i, int j, int[][] garden, int day) {
				int check = 0; 
				
				if(i-1 >= 0 && garden[i-1][j] == 0) {
						garden[i-1][j] = day + 1;
						check++; 
				}
				if(i+1 < garden.length && garden[i+1][j] == 0) {
						garden[i+1][j] = day + 1; 
						check++;
				} 
				if(j-1 >= 0 && garden[i][j-1] == 0) {
						garden[i][j-1] = day + 1;
						check++;
				}
				if(j+1 < garden.length && garden[i][j+1] == 0) {
						garden[i][j+1] = day + 1;
						check++;
				}
				
				return check;
		}
    
    public static void main(String[] args) {
        Main sol = new Main();
        int n1 = 3;
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(n1, garden1);
        
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        int n2 = 2;
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(n2, garden2);
        
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        
    }    
}
