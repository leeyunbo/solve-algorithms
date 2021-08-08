package study;

import java.util.LinkedList;
import java.util.Queue;

public class Problem27 {

    public static void main(String[] args) {
    }

    public int solution(int[][] maps) {
        int answer = -1;
        int le = maps.length;
        int ri = maps[0].length;


        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean[][] checked = new boolean[le][ri];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 1));
        checked[0][0] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.getX() == le-1 && node.getY() == ri-1) {
                answer = node.getLevel();
                break;
            }

            for(int[] direction : directions) {
                int x = node.getX() + direction[0];
                int y = node.getY() + direction[1];

                if((x >= 0 && y >= 0 && x < le && y < ri)
                        && maps[x][y] == 1
                        && !checked[x][y]) {
                    queue.offer(new Node(x, y, node.getLevel() + 1));
                    checked[x][y] = true;
                }
            }
        }

        return answer;
    }

    class Node {
        final private int x;
        final private int y;
        final private int level;
        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getLevel() {
            return level;
        }
    }
}
