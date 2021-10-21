/**
* https://www.acmicpc.net/problem/3197
*/

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BirdLake {

    private static final int[][] DIRS = {{0,-1}, {1,0}, {0,1}, {-1,0}};
    private static int R,C, day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bufferedReader.readLine().split(" ");
        R = Integer.parseInt(arr[0]);
        C = Integer.parseInt(arr[1]);

        char[][] map = new char[R][C];
        List<Integer> locate = new ArrayList<>();
        for(int i=0; i<R; i++) {
            String line = bufferedReader.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'L') {
                    locate.add(i);
                    locate.add(j);
                }
            }
        }

        List<int[]> xLocates = new ArrayList<>();
        while(!bfs(xLocates, map, locate.get(0), locate.get(1)) || !bfs(xLocates, map, locate.get(2), locate.get(3))) {
            next(map, xLocates);
            day += 1;
            xLocates.clear();
        }

        System.out.println(day);
    }

    private static void next(char[][] map, List<int[]> xLocates) {
        for(int[] xLocate : xLocates) {
            map[xLocate[0]][xLocate[1]] = '.';
        }
    }

    private static boolean bfs(List<int[]> xLocates, char[][] map, int x, int y) {
        boolean[][] check = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});
        check[x][y] = true;
        while(!queue.isEmpty()) {
            int[] locate = queue.poll();
            for (int[] dir : DIRS) {
                int nextX = locate[0] + dir[0];
                int nextY = locate[1] + dir[1];
                if ((nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) && !check[nextX][nextY]) {
                    if(map[nextX][nextY] == 'X') {
                        xLocates.add(new int[]{nextX, nextY});
                    }
                    else {
                        if (map[nextX][nextY] == 'L') return true;
                        queue.offer(new int[]{nextX, nextY});
                        check[nextX][nextY] = true;
                    }
                }
            }
        }

        return false;
    }
}
