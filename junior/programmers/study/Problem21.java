package junior.programmers.study;

import java.util.Arrays;

/**
 * 정수 삼각형
 */

public class Problem21 {

    public static void main(String[] args) {
        Problem21 problem21 = new Problem21();
        System.out.println(problem21.solution(new int[][] {{7}, {3, 8},{8, 1, 0},{2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length-1;

        int[][] cache = new int[height+1][triangle[height].length];

        cache[0][0] = triangle[0][0];

        for(int i=0; i<height; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                cache[i+1][j] = Math.max(cache[i][j] + triangle[i+1][j], cache[i+1][j]);
                cache[i+1][j+1] = Math.max(cache[i][j] + triangle[i+1][j+1], cache[i+1][j+1]);
            }
        }


        return Arrays.stream(cache[height]).max().getAsInt();
    }



}
