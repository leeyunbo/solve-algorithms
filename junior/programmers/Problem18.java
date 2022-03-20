package junior.programmers;

import java.util.Arrays;

public class Problem18 {

    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        int[] answer = problem18.solution(3, 3, new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});

        for(int i=0; i<answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int[][] rotateMap = new int[rows][columns];

        int element = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = rotateMap[i][j] = element++;
            }
        }

        for(int i=0; i<queries.length; i++) {
            map = Arrays
                    .stream(rotateMap)
                    .map(int[]::clone)
                    .toArray(int[][]::new);

            for(int j=0; j<=3; j++) queries[i][j] = queries[i][j] - 1;
            answer[i] = rotate(queries[i], rotateMap, map);
        }

        return answer;
    }

    private int rotate(int[] queries, int[][] rotateMap, int[][] map) {
        int min = 654321;
        for(int j=queries[1]; j<queries[3]; j++) {
            rotateMap[queries[0]][j+1] = map[queries[0]][j];
            min = Math.min(min, map[queries[0]][j]);
        }

        for(int j=queries[0]; j<queries[2]; j++) {
            rotateMap[j+1][queries[3]] = map[j][queries[3]];
            min = Math.min(min, map[j][queries[3]]);
        }

        for(int j=queries[3]; j>queries[1]; j--) {
            rotateMap[queries[2]][j-1] = map[queries[2]][j];
            min = Math.min(min, map[queries[2]][j]);
        }

        for(int j=queries[2]; j>queries[0]; j--) {
            rotateMap[j-1][queries[1]] = map[j][queries[1]];
            min = Math.min(min, map[j][queries[1]]);
        }

        return min;
    }
}
