package study;

import java.util.HashMap;

public class Problem28 {

    public static void main(String[] args) {

    }

    public int solution(int[][] board, int[] nums) {
        int answer = 0;
        int n = board.length;
        int[] column = new int[n];
        int[] row = new int[n];
        int[] diagonal = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            hashMap.put(nums[i], 1);


        for(int j=0; j<n; j++) {
            for(int k=0; k<n; k++) {
                if(hashMap.containsKey(board[j][k])) {
                    column[k]++; row[j]++;
                    if(j==k) diagonal[0]++;
                    else if(j+k==n-1) diagonal[1]++;
                }
            }
        }


        for(int i=0; i<column.length; i++) {
            if(column[i] == n || row[i] == n) answer++;
        }

        if(diagonal[0] == n) answer++;
        if(diagonal[1] == n) answer++;

        return answer;
    }
}
