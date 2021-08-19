/**
https://programmers.co.kr/learn/courses/30/lessons/81302
*/
package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Problem22 {

    public static void main(String[] args) {
    }

    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        boolean corona;
        for(int i=0; i<5; i++) {
            corona = false;
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(places[i][j].charAt(k) == 'P' && !bfs(j, k, new boolean[5][5], places[i], dirs)) {
                        answer[i] = 0;
                        corona = true;
                        break;
                    }
                }

                if(corona) break;
            }
        }

        return answer;
    }

    private boolean bfs(int x, int y, boolean[][] checked, String[] places, int[][] dirs) {
        Queue<Section> queue = new LinkedList<>();
        queue.offer(new Section(x, y, 0));
        checked[x][y] = true;
        while(!queue.isEmpty()) {
            Section section = queue.poll();
            if(section.getLevel() >= 2) return true;
            for(int[] dir : dirs) {
                int nX = section.getX() + dir[0];
                int nY = section.getY() + dir[1];
                if((nX >= 0 && nY >= 0 && nX < 5 && nY < 5) && !checked[nX][nY] && places[nX].charAt(nY) != 'X') {
                    if(places[nX].charAt(nY) == 'P') return false;
                    queue.offer(new Section(nX, nY, section.getLevel() + 1));
                    checked[nX][nY] = true;
                }
            }
        }

        return true;
    }

    class Section {
        private int x;
        private int y;
        private int level;

        public Section(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
