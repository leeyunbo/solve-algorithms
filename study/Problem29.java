package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {
    private static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int map[][] = new int[n][20];
        for(int i=0; i<n; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            for(int j=0; j<line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dfs(m, 0, k, map);
        System.out.println(max);
    }

    private static void dfs(int m, int left, int remain, int[][] map) {
        if(left == map.length) return;

        if(remain == 0) {
            max = Math.max(max, calculate(map));
            return;
        }

        for(int i=0; i<=remain; i++) {
            push(map, left, i, m);
            dfs(m, left+1, remain-i, map);
            back(map, left, i, m);
        }
    }

    private static int calculate(int[][] map) {
        int max = 0;
        for(int j=0; j<map[0].length; j++) {
            int sum = 0;
            for(int i=0; i<map.length; i++) {
                sum += map[i][j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    private static void print(int[][] map) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void push(int[][] map, int left, int k, int m) {
        int[] line = map[left];
        int start = 0;
        for(int i=0; i<line.length; i++) {
            if(line[i] > 0) {
                start = i;
                break;
            }
        }

        int end = start + m - 1;
        int[] newLine = new int[line.length];
        for(int i=start; i<=end; i++) {
            newLine[i+k] = line[i];
        }

        map[left] = newLine;
    }

    private static void back(int[][] map, int left, int k, int m) {
        int[] line = map[left];
        int start = 0;
        for(int i=0; i<line.length; i++) {
            if(line[i] > 0) {
                start = i;
                break;
            }
        }

        int end = start + m - 1;
        int[] newLine = new int[line.length];
        for(int i=start; i<=end; i++) {
            newLine[i-k] = line[i];
        }

        map[left] = newLine;
    }
}
